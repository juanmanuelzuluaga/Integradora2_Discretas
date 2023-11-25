package com.example.integradora2_discretas.Algoritmos;

import com.example.integradora2_discretas.Grafo.GrafoV2;

import java.util.*;

public class Recorridos {


    public static List<Integer> bfs(GrafoV2 grafo, int inicio) {
        List<Integer> resultado = new ArrayList<>();
        Queue<Integer> cola = new LinkedList<>();
        Set<Integer> visitados = new HashSet<>();

        cola.add(inicio);
        visitados.add(inicio);

        while (!cola.isEmpty()) {
            int actual = cola.poll();
            resultado.add(actual);

            for (int vecino : grafo.obtenerAdyacencias(actual)) {
                if (!visitados.contains(vecino)) {
                    cola.add(vecino);
                    visitados.add(vecino);
                }
            }
        }

        return resultado;
    }


    public static List<Integer> dfs(GrafoV2 grafo, int inicio) {
        List<Integer> resultado = new ArrayList<>();
        Set<Integer> visitados = new HashSet<>();

        dfsRecursivo(grafo, inicio, visitados, resultado);

        return resultado;
    }

    private static void dfsRecursivo(GrafoV2 grafo, int actual, Set<Integer> visitados, List<Integer> resultado) {
        visitados.add(actual);
        resultado.add(actual);

        for (int vecino : grafo.obtenerAdyacencias(actual)) {
            if (!visitados.contains(vecino)) {
                dfsRecursivo(grafo, vecino, visitados, resultado);
            }
        }
    }
}

