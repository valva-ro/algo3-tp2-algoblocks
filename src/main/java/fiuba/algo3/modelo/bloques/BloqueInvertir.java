package fiuba.algo3.modelo.bloques;

import fiuba.algo3.modelo.SectorDibujo;

public class BloqueInvertir extends DecoratorBloquePersonalizadoBase {

    public BloqueInvertir(Bloques bloque) {
        super(bloque);
    }

    @Override
    public void ejecutar(SectorDibujo sectorDibujo) {
        super.ejecutarInvertido(sectorDibujo);
        super.ejecutarBloquesInvertidos(sectorDibujo);
    }

    @Override
    public void ejecutarInvertido(SectorDibujo sectorDibujo){
        super.ejecutar(sectorDibujo);
        super.ejecutarBloques(sectorDibujo);
    }
}