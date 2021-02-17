package fiuba.algo3.modelo;

import fiuba.algo3.modelo.bloques.*;
import fiuba.algo3.modelo.direcciones.Este;
import fiuba.algo3.modelo.direcciones.Norte;
import fiuba.algo3.modelo.direcciones.Oeste;
import fiuba.algo3.modelo.direcciones.Sur;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class AlgoritmoTests {

    @Test
    public void test01NoSePuedeEjecutarUnAlgoritmoQueNoTieneBloques() {
        Algoritmo algoritmo = new Algoritmo();
        SectorDibujo sectorDibujo = new SectorDibujo();

        assertThrows(AlgoritmoNoPuedeSerEjecutadoSiNoTieneBloquesError.class,
                () -> {
                    algoritmo.ejecutar(sectorDibujo);
                });
    }

    @Test
    public void test02SeEjecutaUnAlgoritmoCon1BloquesDeMovimientoHaciaElNorteYLapizLevantado() {
        Algoritmo algoritmo = new Algoritmo();
        SectorDibujo sectorDibujo = new SectorDibujo();
        BloqueMovimiento bloqueNorte = new BloqueMovimiento(new Norte());

        algoritmo.agregar(bloqueNorte);
        algoritmo.ejecutar(sectorDibujo);

        assertFalse(sectorDibujo.existe(new Posicion(0, 1)));
    }

    @Test
    public void test03SeEjecutaUnAlgoritmoCon1BloquesDeMovimientoHaciaElNorteYLapizAbajo() {
        Algoritmo algoritmo = new Algoritmo();
        SectorDibujo sectorDibujo = new SectorDibujo();
        BloqueMovimiento bloqueNorte = new BloqueMovimiento(new Norte());

        sectorDibujo.invertirDibuja();
        algoritmo.agregar(bloqueNorte);
        algoritmo.ejecutar(sectorDibujo);

        assertTrue(sectorDibujo.existe(new Posicion(0, 1)));
    }

    @Test
    public void test04SeEjecutaUnAlgoritmoCon1BloquesDeMovimientoHaciaElSurYLapizLevantado() {
        Algoritmo algoritmo = new Algoritmo();
        SectorDibujo sectorDibujo = new SectorDibujo();
        BloqueMovimiento bloqueNorte = new BloqueMovimiento(new Sur());

        algoritmo.agregar(bloqueNorte);
        algoritmo.ejecutar(sectorDibujo);

        assertFalse(sectorDibujo.existe(new Posicion(0, -1)));
    }

    @Test
    public void test05SeEjecutaUnAlgoritmoCon1BloquesDeMovimientoHaciaElSurYLapizAbajo() {
        Algoritmo algoritmo = new Algoritmo();
        SectorDibujo sectorDibujo = new SectorDibujo();
        BloqueMovimiento bloqueSur = new BloqueMovimiento(new Sur());

        sectorDibujo.invertirDibuja();
        algoritmo.agregar(bloqueSur);
        algoritmo.ejecutar(sectorDibujo);

        assertTrue(sectorDibujo.existe(new Posicion(0, -1)));
    }

    @Test
    public void test06SeEjecutaUnAlgoritmoCon1BloquesDeMovimientoHaciaElEsteYLapizLevantado() {
        Algoritmo algoritmo = new Algoritmo();
        SectorDibujo sectorDibujo = new SectorDibujo();
        BloqueMovimiento bloqueSur = new BloqueMovimiento(new Norte());

        algoritmo.agregar(bloqueSur);
        algoritmo.ejecutar(sectorDibujo);

        assertFalse(sectorDibujo.existe(new Posicion(1, 0)));
    }

    @Test
    public void test07SeEjecutaUnAlgoritmoCon1BloquesDeMovimientoHaciaElEsteYLapizAbajo() {
        Algoritmo algoritmo = new Algoritmo();
        SectorDibujo sectorDibujo = new SectorDibujo();
        BloqueMovimiento bloqueEste = new BloqueMovimiento(new Este());

        sectorDibujo.invertirDibuja();
        algoritmo.agregar(bloqueEste);
        algoritmo.ejecutar(sectorDibujo);

        assertTrue(sectorDibujo.existe(new Posicion(1, 0)));
    }

    @Test
    public void test06SeEjecutaUnAlgoritmoCon1BloquesDeMovimientoHaciaElOesteYLapizLevantado() {
        Algoritmo algoritmo = new Algoritmo();
        SectorDibujo sectorDibujo = new SectorDibujo();
        BloqueMovimiento bloqueOeste = new BloqueMovimiento(new Oeste());

        algoritmo.agregar(bloqueOeste);
        algoritmo.ejecutar(sectorDibujo);

        assertFalse(sectorDibujo.existe(new Posicion(-1, 0)));
    }

    @Test
    public void test09SeEjecutaUnAlgoritmoCon1BloquesDeMovimientoHaciaElOesteYLapizAbajo() {
        Algoritmo algoritmo = new Algoritmo();
        SectorDibujo sectorDibujo = new SectorDibujo();
        BloqueMovimiento bloqueOeste = new BloqueMovimiento(new Oeste());

        sectorDibujo.invertirDibuja();
        algoritmo.agregar(bloqueOeste);
        algoritmo.ejecutar(sectorDibujo);

        assertTrue(sectorDibujo.existe(new Posicion(-1, 0)));
    }

    @Test
    public void test10SeEjecutaUnAlgoritmoCon1BloquesDeMovimientoHaciaCadaDireccionYLapizAbajo() {
        Algoritmo algoritmo = new Algoritmo();
        SectorDibujo sectorDibujo = new SectorDibujo();
        BloqueMovimiento bloqueNorte = new BloqueMovimiento(new Norte());
        BloqueMovimiento bloqueSur = new BloqueMovimiento(new Sur());
        BloqueMovimiento bloqueEste = new BloqueMovimiento(new Este());
        BloqueMovimiento bloqueOeste = new BloqueMovimiento(new Oeste());

        sectorDibujo.invertirDibuja();
        algoritmo.agregar(bloqueNorte);
        algoritmo.agregar(bloqueEste);
        algoritmo.agregar(bloqueSur);
        algoritmo.agregar(bloqueOeste);

        algoritmo.ejecutar(sectorDibujo);

        assertTrue(sectorDibujo.existe(new Posicion(0, 1))); // Norte
        assertTrue(sectorDibujo.existe(new Posicion(1, 1))); // Este
        assertTrue(sectorDibujo.existe(new Posicion(1, 0))); // Sur
        assertTrue(sectorDibujo.existe(new Posicion(0, 0))); // Oeste
    }

    @Test
    public void test11SeEjecutaUnAlgoritmoConUnBloqueDeRepeticionDobleQueTieneDosBloquesHaciaElNorteYLapizAbajo() {
        Algoritmo algoritmo = new Algoritmo();
        SectorDibujo sectorDibujo = new SectorDibujo();
        BloqueRepetirDosVeces bloqueRepeticionDoble = new BloqueRepetirDosVeces();
        BloqueMovimiento bloqueNorte = new BloqueMovimiento(new Norte());

        sectorDibujo.invertirDibuja();

        bloqueRepeticionDoble.agregar(bloqueNorte);
        bloqueRepeticionDoble.agregar(bloqueNorte);
        algoritmo.agregar(bloqueRepeticionDoble);

        algoritmo.ejecutar(sectorDibujo);

        assertTrue(sectorDibujo.existe(new Posicion(0, 1)));
        assertTrue(sectorDibujo.existe(new Posicion(0, 2)));
        assertTrue(sectorDibujo.existe(new Posicion(0, 3)));
        assertTrue(sectorDibujo.existe(new Posicion(0, 4)));
    }

    @Test
    public void test12SeEjecutaUnAlgoritmoConUnBloqueDeRepeticionDobleQueTieneDosBloquesHaciaElNorteDosHaciaElEsteYLapizAbajo() {
        Algoritmo algoritmo = new Algoritmo();
        SectorDibujo sectorDibujo = new SectorDibujo();
        BloqueRepetirDosVeces bloqueRepeticionDoble = new BloqueRepetirDosVeces();
        BloqueMovimiento bloqueNorte = new BloqueMovimiento(new Norte());
        BloqueMovimiento bloqueEste = new BloqueMovimiento(new Este());

        sectorDibujo.invertirDibuja();

        bloqueRepeticionDoble.agregar(bloqueNorte);
        bloqueRepeticionDoble.agregar(bloqueNorte);
        bloqueRepeticionDoble.agregar(bloqueEste);
        bloqueRepeticionDoble.agregar(bloqueEste);
        algoritmo.agregar(bloqueRepeticionDoble);

        algoritmo.ejecutar(sectorDibujo);

        assertTrue(sectorDibujo.existe(new Posicion(0, 1)));
        assertTrue(sectorDibujo.existe(new Posicion(0, 2)));
        assertTrue(sectorDibujo.existe(new Posicion(1, 2)));
        assertTrue(sectorDibujo.existe(new Posicion(2, 2)));
        assertTrue(sectorDibujo.existe(new Posicion(2, 3)));
        assertTrue(sectorDibujo.existe(new Posicion(2, 4)));
        assertTrue(sectorDibujo.existe(new Posicion(3, 4)));
        assertTrue(sectorDibujo.existe(new Posicion(4, 4)));
    }

    @Test
    public void test13SeEjecutaUnAlgoritmoConUnBloqueDeRepeticionTripkeQueTieneUnBloqueHaciaElNorteYLapizAbajo() {
        Algoritmo algoritmo = new Algoritmo();
        SectorDibujo sectorDibujo = new SectorDibujo();
        BloqueRepetirTresVeces bloqueRepeticionTriple = new BloqueRepetirTresVeces();
        BloqueMovimiento bloqueNorte = new BloqueMovimiento(new Norte());

        sectorDibujo.invertirDibuja();

        bloqueRepeticionTriple.agregar(bloqueNorte);
        algoritmo.agregar(bloqueRepeticionTriple);

        algoritmo.ejecutar(sectorDibujo);

        assertTrue(sectorDibujo.existe(new Posicion(0, 1)));
        assertTrue(sectorDibujo.existe(new Posicion(0, 2)));
        assertTrue(sectorDibujo.existe(new Posicion(0, 3)));
    }

    @Test
    public void test14SeEjecutaUnAlgoritmoConUnBloqueDeRepeticionTripkeQueTieneDosBloquesHaciaElNorteYLapizAbajo() {
        Algoritmo algoritmo = new Algoritmo();
        SectorDibujo sectorDibujo = new SectorDibujo();
        BloqueRepetirTresVeces bloqueRepeticionTriple = new BloqueRepetirTresVeces();
        BloqueMovimiento bloqueNorte = new BloqueMovimiento(new Norte());

        sectorDibujo.invertirDibuja();

        bloqueRepeticionTriple.agregar(bloqueNorte);
        bloqueRepeticionTriple.agregar(bloqueNorte);
        algoritmo.agregar(bloqueRepeticionTriple);

        algoritmo.ejecutar(sectorDibujo);

        assertTrue(sectorDibujo.existe(new Posicion(0, 1)));
        assertTrue(sectorDibujo.existe(new Posicion(0, 2)));
        assertTrue(sectorDibujo.existe(new Posicion(0, 3)));
        assertTrue(sectorDibujo.existe(new Posicion(0, 4)));
        assertTrue(sectorDibujo.existe(new Posicion(0, 5)));
        assertTrue(sectorDibujo.existe(new Posicion(0, 6)));
    }
}