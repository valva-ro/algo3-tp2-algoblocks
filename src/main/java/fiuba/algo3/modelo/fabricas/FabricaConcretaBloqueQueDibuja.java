package fiuba.algo3.modelo.fabricas;

import fiuba.algo3.modelo.bloques.BloqueMovimiento;
import fiuba.algo3.modelo.bloques.Estado;
import fiuba.algo3.modelo.bloques.Dibuja;
import fiuba.algo3.modelo.direcciones.Este;
import fiuba.algo3.modelo.direcciones.Norte;
import fiuba.algo3.modelo.direcciones.Oeste;
import fiuba.algo3.modelo.direcciones.Sur;

public class FabricaConcretaBloqueQueDibuja implements FabricaAbstractaDeBloques {

    private Estado estado = new Dibuja();

    @Override
    public BloqueMovimiento crearBloqueMovimientoArriba() {
        return new BloqueMovimiento(new Norte(), estado);
    }

    @Override
    public BloqueMovimiento crearBloqueMovimientoAbajo() {
        return new BloqueMovimiento(new Sur(), estado);
    }

    @Override
    public BloqueMovimiento crearBloqueMovimientoIzquierda() {
        return new BloqueMovimiento(new Oeste(), estado);
    }

    @Override
    public BloqueMovimiento crearBloqueMovimientoDerecha() {
        return new BloqueMovimiento(new Este(), estado);
    }

    @Override
    public void cambiarDeFabrica(){
        this.estado = estado.cambiarEstado();
    }
}