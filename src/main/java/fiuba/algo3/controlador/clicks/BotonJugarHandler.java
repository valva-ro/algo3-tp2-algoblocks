package fiuba.algo3.controlador.clicks;

import fiuba.algo3.App;
import fiuba.algo3.modelo.Algoritmo;
import fiuba.algo3.modelo.SectorBloques;
import fiuba.algo3.modelo.SectorDibujo;
import fiuba.algo3.modelo.fabricas.FabricaAbstractaDeBloques;
import fiuba.algo3.vista.ventanas.VistaPrincipal;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class BotonJugarHandler extends BotonClickHandler {

    private Stage escenario;
    VistaPrincipal vistaPrincipal;

    public BotonJugarHandler(App aplicacion, Stage escenario, SectorDibujo sectorDibujo, SectorBloques sectorBloques, Algoritmo algoritmo, FabricaAbstractaDeBloques fabricaDeBloques) {
        super();
        this.escenario = escenario;
        this.vistaPrincipal = new VistaPrincipal(aplicacion, escenario, sectorDibujo, sectorBloques, algoritmo, fabricaDeBloques);
    }

    @Override
    public void handle(ActionEvent event) {
        super.handle(event);
        Scene nuevaScena = new Scene(this.vistaPrincipal);

        escenario.setScene(nuevaScena);
        escenario.setFullScreen(true);
        escenario.setFullScreenExitHint("");
        escenario.setMinHeight(600);
        escenario.setMinWidth(1200);
    }
}