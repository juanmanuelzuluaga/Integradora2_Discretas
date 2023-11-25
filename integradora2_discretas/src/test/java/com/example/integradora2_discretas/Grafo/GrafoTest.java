package com.example.integradora2_discretas.Grafo;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
public class GrafoTest {

    @Test
    public void testAgregarVertice() {
        GrafoV2 grafo = new GrafoV2();
        grafo.agregarVertice(1);
        grafo.agregarVertice(2);
        grafo.agregarVertice(3);

        assertEquals(3, grafo.obtenerNumeroVertices());
    }

    @Test
    public void testAgregarArista() {
        GrafoV2 grafo = new GrafoV2();
        grafo.agregarVertice(1);
        grafo.agregarVertice(2);
        grafo.agregarArista(1, 2);

        assertEquals(1, grafo.obtenerNumeroAristas());
        assertTrue(grafo.existeArista(1, 2));
        assertTrue(grafo.existeArista(2, 1));
    }

    @Test
    public void testObtenerAdyacencias() {
        GrafoV2 grafo = new GrafoV2();
        grafo.agregarVertice(1);
        grafo.agregarVertice(2);
        grafo.agregarVertice(3);
        grafo.agregarArista(1, 2);
        grafo.agregarArista(1, 3);

        assertTrue(grafo.obtenerAdyacencias(1).contains(2));
        assertTrue(grafo.obtenerAdyacencias(1).contains(3));
        assertEquals(2, grafo.obtenerAdyacencias(1).size());
    }

    @Test
    public void testEliminarVertice() {
        GrafoV2 grafo = new GrafoV2();
        grafo.agregarVertice(1);
        grafo.agregarVertice(2);
        grafo.agregarArista(1, 2);

        grafo.eliminarVertice(1);

        assertEquals(1, grafo.obtenerNumeroVertices());
        assertEquals(0, grafo.obtenerNumeroAristas());
        assertFalse(grafo.obtenerAdyacencias(2).contains(1));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAristaConVeticesInexistentes() {
        GrafoV2 grafo = new GrafoV2();
        grafo.agregarArista(1, 2);
    }


}

