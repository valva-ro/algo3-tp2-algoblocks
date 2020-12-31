package fiuba.algo3.modelo.movimientos;

import fiuba.algo3.modelo.bloques.Estado;

public class Izquierda extends Movimiento {

    public Izquierda(Estado estado) {
        this.estado = estado;
    }

    @Override
    public Movimiento invertir() {
        return new Derecha(estado);
    }
}