package com.example.integradora2_discretas.Juego;

import org.junit.jupiter.api.Test;
import java.awt.Point;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JugadorTest {

    @Test
    public void testMoverArriba() {
        Jugador jugador = new Jugador(1, 1);

        jugador.moverArriba();

        assertEquals(new Point(1, 0), jugador.getPosicion());
    }

    @Test
    public void testMoverAbajo() {
        Jugador jugador = new Jugador(1, 1);

        jugador.moverAbajo();

        assertEquals(new Point(1, 2), jugador.getPosicion());
    }

    @Test
    public void testMoverIzquierda() {
        Jugador jugador = new Jugador(1, 1);

        jugador.moverIzquierda();

        assertEquals(new Point(0, 1), jugador.getPosicion());
    }

    @Test
    public void testMoverDerecha() {
        Jugador jugador = new Jugador(1, 1);

        jugador.moverDerecha();

        assertEquals(new Point(2, 1), jugador.getPosicion());
    }

}
