package fiuba.algo3.modelo;

import fiuba.algo3.modelo.bloques.*;
import fiuba.algo3.modelo.movimientos.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BloquePersonalizadoTests {

    @Test
    public void test01BloquePersonalizadoSeEjecutaConUnBloqueDeMovimientoHaciaLaDerecha () {

        BloquePersonalizado bloque = new BloquePersonalizado();
        SectorDibujo sectorDibujo = new SectorDibujo();
        Movimiento movimiento = new Derecha(new Dibuja());
        BloqueMovimiento bloqueMovimiento = new BloqueMovimiento(movimiento);

        bloque.agregar(bloqueMovimiento);
        bloque.ejecutar(sectorDibujo);

        assertEquals(movimiento, sectorDibujo.obtenerMovimientos().get(0));
    }

    @Test
    public void test02DecoratorDeBloquePersonalizadoBaseNoAlteraElComportamientoDelBloquePersonalizado () {

        BloquePersonalizado bloque = new BloquePersonalizado();
        SectorDibujo sectorDibujo = new SectorDibujo();
        Movimiento movimiento = new Derecha(new Dibuja());
        BloqueMovimiento bloqueMovimiento = new BloqueMovimiento(movimiento);

        bloque.agregar(bloqueMovimiento);

        DecoratorBloquePersonalizadoBase decorator = new DecoratorBloquePersonalizadoBase(bloque);

        decorator.ejecutar(sectorDibujo);

        assertEquals(movimiento, sectorDibujo.obtenerMovimientos().get(0));
    }

    @Test
    public void test03BloquePersonalizadoSeEjecutaCon5BloquesDeMovimientoHaciaLaDerechaY5HaciaArriba () {

        BloquePersonalizado bloque = new BloquePersonalizado();
        SectorDibujo sectorDibujo = new SectorDibujo();
        Derecha derecha = new Derecha(new Dibuja());
        Arriba arriba = new Arriba(new Dibuja());

        for (int i = 0; i < 5; i++) {
            bloque.agregar(new BloqueMovimiento(derecha));
            bloque.agregar(new BloqueMovimiento(arriba));
        }

        bloque.ejecutar(sectorDibujo);

        for (int i = 0; i < 5; i += 2) {
            assertEquals(derecha, sectorDibujo.obtenerMovimientos().get(i));
            assertEquals(arriba, sectorDibujo.obtenerMovimientos().get(i+1));
        }
    }

    @Test
    public void test04BloquePersonalizadoNoPuedeEjecutarseSinAlMenosUnBloque () {

        BloquePersonalizado bloque = new BloquePersonalizado();
        SectorDibujo sectorDibujo = new SectorDibujo();

        assertThrows(BloquePersonalizadoNoPuedeEjecutarseSinBloquesError.class,
                () -> {
                    bloque.ejecutar(sectorDibujo);
                });
    }

    @Test
    public void test05BloquePersonalizadoSeEjecutaConDecoratorInvertirYBloquesDeMovimiento () {

        BloquePersonalizado bloque = new BloquePersonalizado();
        // TODO: falta DecoratorInvertir
        // DecoratorInvertirBloquePersonalizado invertir;
        SectorDibujo sectorDibujo = new SectorDibujo();
        Derecha derecha = new Derecha(new Dibuja());
        Izquierda izquierda = new Izquierda(new Dibuja());
        Arriba arriba = new Arriba(new Dibuja());
        Abajo abajo = new Abajo(new Dibuja());

        for (int i = 0; i < 5; i++) {
            bloque.agregar(new BloqueMovimiento(derecha));
            bloque.agregar(new BloqueMovimiento(arriba));
        }

        /*
        invertir = new DecoratorInvertirBloquePersonalizado(bloque);

        invertir.ejecutar(sectorDibujo);

        for (int i = 0; i < 5; i += 2) {
            assertEquals(izquierda, sectorDibujo.obtenerMovimientos().get(i));
            assertEquals(abajo, sectorDibujo.obtenerMovimientos().get(i+1));
        }
         */
    }
}
