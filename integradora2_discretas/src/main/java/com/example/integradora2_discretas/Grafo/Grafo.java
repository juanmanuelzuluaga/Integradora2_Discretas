package com.example.integradora2_discretas.Grafo;

import com.example.integradora2_discretas.Algoritmos.MST;

import java.util.*;

public class Grafo {
    private Map<Integer, List<Integer>> adyacencias;

    public Grafo() {
        this.adyacencias = new HashMap<>();
    }

    public void agregarVertice(int vertice) {
        if (!adyacencias.containsKey(vertice)) {
            adyacencias.put(vertice, new ArrayList<>());
        } else {
            System.out.println("El vértice " + vertice + " ya existe en el grafo.");
        }
    }

    public void agregarArista(int origen, int destino) {
        if (adyacencias.containsKey(origen) && adyacencias.containsKey(destino)) {
            adyacencias.get(origen).add(destino);
            adyacencias.get(destino).add(origen);
        } else {
            System.out.println("Al menos uno de los vértices no existe en el grafo.");
        }
    }

    public List<Integer> obtenerAdyacencias(int vertice) {
        return adyacencias.getOrDefault(vertice, new ArrayList<>());
    }

    public int obtenerNumeroVertices() {
        return adyacencias.size();
    }

    public int obtenerNumeroAristas() {
        int totalAristas = 0;
        for (List<Integer> adyacencia : adyacencias.values()) {
            totalAristas += adyacencia.size();
        }
        return totalAristas / 2;
    }

    public void imprimirGrafo() {
        System.out.println("Grafo:");
        for (Map.Entry<Integer, List<Integer>> entry : adyacencias.entrySet()) {
            int vertice = entry.getKey();
            List<Integer> adyacentes = entry.getValue();
            System.out.print(vertice + " -> ");
            for (int adyacente : adyacentes) {
                System.out.print(adyacente + " ");
            }
            System.out.println();
        }
    }

    public Iterable<Object> obtenerVertices() {
        return null;
    }

    public MST.Arista[] obtenerAristasAdyacentes(int inicio) {
        return new MST.Arista[0];
    }

    public int obtenerAristas() {
        return 0;
    }
}

