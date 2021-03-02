package fiuba.algo3.vista.sectores;

import fiuba.algo3.App;
import fiuba.algo3.controlador.clicks.BotonAtrasHandler;
import fiuba.algo3.controlador.clicks.BotonEjecutarAlgoritmoHandler;
import fiuba.algo3.controlador.clicks.LimpiadorDeAlgoritmoHandler;
import fiuba.algo3.controlador.drags.SeccionAlgoritmoDragDroppedEventHandler;
import fiuba.algo3.controlador.drags.SeccionAlgoritmoDragOverHandler;
import fiuba.algo3.modelo.Algoritmo;
import fiuba.algo3.modelo.Observador;
import fiuba.algo3.modelo.SectorDibujo;
import fiuba.algo3.modelo.fabricas.FabricaAbstractaDeBloques;
import fiuba.algo3.vista.botones.Boton;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SectorAlgoritmoVista extends VBox implements Observador {

    private final Algoritmo algoritmo;
    private final SectorDibujoVista sectorDibujoVista;
    private final FabricaAbstractaDeBloques fabricaDeBloques;
    private final VBox bloquesDelAlgoritmo;
    private final HBox botonera;
    private Boton botonLimpiarDibujo;
    private Boton botonEjectuar;

    public SectorAlgoritmoVista(Algoritmo algoritmo, App aplicacion, Stage escenario, FabricaAbstractaDeBloques fabricaDeBloques, SectorDibujoVista sectorDibujoVista) {
        super();
        this.algoritmo = algoritmo;
        this.sectorDibujoVista = sectorDibujoVista;
        this.fabricaDeBloques = fabricaDeBloques;
        this.algoritmo.agregarObservador(this);
        this.botonera = this.botoneraAccionesDisponibles(aplicacion, escenario);
        this.bloquesDelAlgoritmo = new VBox();
        this.configurarVentana();
    }

    private void configurarVentana() {
        Label etiqueta = new Label("Algoritmo");
        etiqueta.getStyleClass().add("subtitulo");

        this.configurarContenidoVentana();

        this.getStylesheets().add("style.css");
        this.setAlignment(Pos.TOP_CENTER);
        this.setMinWidth(400);

        ScrollPane sectorScrolleable = new ScrollPane(this.bloquesDelAlgoritmo);
        sectorScrolleable.setFitToHeight(true);
        sectorScrolleable.setFitToWidth(true);
        sectorScrolleable.setMinHeight(550);
        sectorScrolleable.setMaxHeight(550);
        sectorScrolleable.setMaxWidth(350);
        sectorScrolleable.setOnDragOver(new SeccionAlgoritmoDragOverHandler(this.bloquesDelAlgoritmo));
        sectorScrolleable.setOnDragDropped(new SeccionAlgoritmoDragDroppedEventHandler(this.algoritmo, this.bloquesDelAlgoritmo, this.fabricaDeBloques));

        this.getChildren().addAll(etiqueta, this.botonera, sectorScrolleable);
    }

    private void configurarContenidoVentana() {
        this.bloquesDelAlgoritmo.getChildren().clear();
        this.bloquesDelAlgoritmo.setAlignment(Pos.CENTER);

        this.botonLimpiarDibujo.setDisable(this.algoritmo.estaVacio());
    }

    private HBox botoneraAccionesDisponibles(App aplicacion, Stage escenario) {

        this.botonLimpiarDibujo = new Boton("botonLimpiarDibujo", "");
        this.botonEjectuar = new Boton("botonEjecutar", "");
        this.botonLimpiarDibujo.setOnAction(new LimpiadorDeAlgoritmoHandler(this.algoritmo, this.sectorDibujoVista));
        this.botonEjectuar.setOnAction(new BotonEjecutarAlgoritmoHandler(this.algoritmo, this.sectorDibujoVista));
        this.botonLimpiarDibujo.setDisable(true);
        this.botonEjectuar.setDisable(true);

        Boton botonAtras = new Boton("botonAtras", "");
        Boton botonSalir = new Boton("botonSalir", "Salir");
        botonAtras.setOnAction(new BotonAtrasHandler(aplicacion, escenario));
        botonSalir.setOnAction(actionEvent -> Platform.exit());

        HBox botonera = new HBox();
        botonera.setAlignment(Pos.CENTER);
        botonera.getChildren().addAll(botonEjectuar, botonLimpiarDibujo, botonAtras, botonSalir);

        return botonera;
    }

    @Override
    public void actualizar() {
        this.botonLimpiarDibujo.setDisable(this.algoritmo.estaVacio());
        this.botonEjectuar.setDisable(this.algoritmo.estaVacio());
        if (this.algoritmo.estaVacio()) {
            this.configurarContenidoVentana();
        }
    }
}
