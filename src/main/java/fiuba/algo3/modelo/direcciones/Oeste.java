package fiuba.algo3.modelo.direcciones;
import fiuba.algo3.modelo.Posicion;

public class Oeste extends Direccion {

    public Oeste() {
        this.x = -1;
        this.y = 0;
    }

    @Override
    public Direccion invertir() {
        return new Este();
    }
}
