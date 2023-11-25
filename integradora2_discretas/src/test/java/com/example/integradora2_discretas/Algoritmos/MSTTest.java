package com.example.integradora2_discretas.Algoritmos;

import com.example.integradora2_discretas.Grafo.GrafoV2;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MSTTest {

    @Test
    public void testPrim() throws InterruptedException {
        GrafoV2 grafo = new GrafoV2();

        Set<MST.Arista> mstPrim = MST.prim(grafo);

        assertEquals(grafo.obtenerNumeroVertices() - 1, mstPrim.size());
    }

    @Test
    public void testKruskal() {
        GrafoV2 grafo = new GrafoV2();

        Set<MST.Arista> mstKruskal = MST.kruskal(grafo);

        assertEquals(grafo.obtenerNumeroVertices() - 1, mstKruskal.size());
    }

}

