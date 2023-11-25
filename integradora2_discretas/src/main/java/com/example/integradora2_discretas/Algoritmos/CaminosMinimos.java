package com.example.integradora2_discretas.Algoritmos;

import com.example.integradora2_discretas.Grafo.GrafoV2;

import java.util.*;

public class CaminosMinimos {

    public static Map<Integer, Integer> dijkstra(GrafoV2 grafo, int inicio) {
        Map<Integer, Integer> distancias = new HashMap<>();
        Set<Integer> visitados = new HashSet<>();
        PriorityQueue<Nodo> colaPrioridad = new PriorityQueue<>(Comparator.comparingInt(distancias::get));

        for (int vertice : grafo.obtenerVertices()) {
            distancias.put(vertice, Integer.MAX_VALUE);
        }
        distancias.put(inicio, 0);

        colaPrioridad.add(new Nodo(inicio, 0));

        while (!colaPrioridad.isEmpty()) {
            int actual = colaPrioridad.poll().vertice;
            if (visitados.contains(actual)) continue;

            visitados.add(actual);

            for (int vecino : grafo.obtenerAdyacencias(actual)) {
                int nuevaDistancia = distancias.get(actual) + grafo.obtenerPesoArista(actual, vecino);

                if (nuevaDistancia < distancias.get(vecino)) {
                    distancias.put(vecino, nuevaDistancia);
                    colaPrioridad.add(new Nodo(vecino, nuevaDistancia));
                }
            }
        }

        return distancias;
    }

    public static int[][] floydWarshall(GrafoV2 grafo) {
        int numVertices = grafo.obtenerNumeroVertices();
        int[][] distancias = new int[numVertices][numVertices];

        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                distancias[i][j] = Integer.MAX_VALUE;
            }
        }

        for (int vertice : grafo.obtenerVertices()) {
            for (int vecino : grafo.obtenerAdyacencias(vertice)) {
                distancias[vertice][vecino] = grafo.obtenerPesoArista(vertice, vecino);
            }
        }

        for (int k = 0; k < numVertices; k++) {
            for (int i = 0; i < numVertices; i++) {
                for (int j = 0; j < numVertices; j++) {
                    if (distancias[i][k] != Integer.MAX_VALUE && distancias[k][j] != Integer.MAX_VALUE) {
                        distancias[i][j] = Math.min(distancias[i][j], distancias[i][k] + distancias[k][j]);
                    }
                }
            }
        }

        return distancias;
    }

    private static class Nodo {
        private int vertice;
        private int distancia;

        public Nodo(int vertice, int distancia) {
            this.vertice = vertice;
            this.distancia = distancia;
        }
    }
}

