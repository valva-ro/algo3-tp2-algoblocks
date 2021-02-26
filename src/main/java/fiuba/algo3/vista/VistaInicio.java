package fiuba.algo3.vista;

import fiuba.algo3.App;
import fiuba.algo3.controlador.BotonAcercaDeHandler;
import fiuba.algo3.controlador.BotonJugarHandler;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class VistaInicio extends VBox {

    private static final String RUTA_ICONO = "logo.png";
    private static final int ANCHO = 250;
    private static final int ALTO = 250;
    Stage escenario;

    public VistaInicio(App aplicacion, Stage escenario) {
        super();

        this.escenario = escenario;
        this.setAlignment(Pos.CENTER);

        Boton botonJugar = new Boton("botonJugar", "Jugar");
        Boton botonAcercaDe = new Boton("botonAcercaDe", "Acerca de");
        Boton botonSalir = new Boton("botonSalir", "Salir");

        BotonJugarHandler botonJugarHandler = new BotonJugarHandler(aplicacion, escenario);
        botonJugar.setOnAction(botonJugarHandler);

        BotonAcercaDeHandler botonAcercaDeHandler = new BotonAcercaDeHandler(aplicacion, escenario);
        botonAcercaDe.setOnAction(botonAcercaDeHandler);

        botonSalir.setOnAction(actionEvent -> Platform.exit());

        HBox botonera = new HBox(botonJugar, botonAcercaDe, botonSalir);
        botonera.setAlignment(Pos.CENTER);

        botonera.getStylesheets().clear();
        botonera.getStylesheets().add("style.css");

        Image imagen = new Image(RUTA_ICONO);
        ImageView vistaDeImagen = new ImageView(imagen);
        vistaDeImagen.setFitWidth(ANCHO);
        vistaDeImagen.setFitHeight(ALTO);

        this.setStyle("-fx-background-color: #abe389");
        Label etiqueta = new Label("Bienvenidos a AlgoBlocks!");
        etiqueta.getStyleClass().add("titulo");

        this.getChildren().addAll(etiqueta, vistaDeImagen, botonera);
    }
}
