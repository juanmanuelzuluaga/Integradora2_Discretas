package com.example.integradora2_discretas.Algoritmos;

import com.example.integradora2_discretas.Grafo.GrafoV2;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.Arrays;
import java.util.List;

public class RecorridosTest {

    @Test
    public void testBFS() {
        GrafoV2 grafo = new GrafoV2();

        List<Integer> resultadoBFS = Recorridos.bfs(grafo, 0);

        List<Integer> resultadoEsperado = Arrays.asList(0, 1, 2, 3, 4);
        assertEquals(resultadoEsperado, resultadoBFS);
    }

    @Test
    public void testDFS() {
        GrafoV2 grafo = new GrafoV2();

        List<Integer> resultadoDFS = Recorridos.dfs(grafo, 0);

        List<Integer> resultadoEsperado = Arrays.asList(0, 1, 2, 3, 4);
        assertEquals(resultadoEsperado, resultadoDFS);
    }

}

