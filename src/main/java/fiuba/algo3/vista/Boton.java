package fiuba.algo3.vista;

import javafx.scene.control.Button;

public class Boton extends Button {

    public Boton(String bloqueID, String texto) {
        super(texto);
        this.setId(bloqueID);
        this.getStyleClass().addAll("boton", "bloque", "bloqueMovimiento");
    }
}
