package fiuba.algo3.vista;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

public class Tablero extends Canvas {

    private int xFinal;
    private int yFinal;

    public Tablero(double ancho, double alto) {
        super(ancho, alto);
        this.xFinal = (int) ((this.getWidth()) / 2);
        this.yFinal = (int) ((this.getHeight()) / 2);
    }

    private void dibujarMovimientos() {
        GraphicsContext graphicadorContext = this.getGraphicsContext2D();
        graphicadorContext.strokeLine(0, this.xFinal, 0, this.yFinal);
    }

    public void dibujar() {
        this.dibujarMovimientos();
    }
}
