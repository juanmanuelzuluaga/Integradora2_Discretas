package com.example.integradora2_discretas.Algoritmos;

import com.example.integradora2_discretas.Grafo.GrafoV2;
import org.junit.jupiter.api.Test;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CaminosMinimosTest {

    @Test
    public void testDijkstra() {
        GrafoV2 grafo = new GrafoV2();

        int inicioDijkstra = 0;
        Map<Integer, Integer> distanciasDijkstra = CaminosMinimos.dijkstra(grafo, inicioDijkstra);

        assertEquals(0, distanciasDijkstra.get(inicioDijkstra));
        Integer otroNodo = null;
        assertEquals(3, distanciasDijkstra.get(otroNodo));
    }

    @Test
    public void testFloydWarshall() {
        GrafoV2 grafo = new GrafoV2();

        int[][] distanciasFloydWarshall = CaminosMinimos.floydWarshall(grafo);

        int inicio = 0;
        assertEquals(0, distanciasFloydWarshall[inicio][inicio]);
    }

}

