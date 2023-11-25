package com.example.integradora2_discretas.Grafo;

import java.util.*;

public class GrafoV1 {
    private Map<Integer, List<Integer>> adyacencias;

    public GrafoV1() {
        this.adyacencias = new HashMap<>();
    }

    public void agregarVertice(int vertice) {
        if (!adyacencias.containsKey(vertice)) {
            adyacencias.put(vertice, new ArrayList<>());
        } else {
            throw new IllegalArgumentException("El vértice " + vertice + " ya existe en el grafo.");
        }
    }

    public void agregarArista(int origen, int destino) {
        if (adyacencias.containsKey(origen) && adyacencias.containsKey(destino)) {
            adyacencias.get(origen).add(destino);
            adyacencias.get(destino).add(origen);
        } else {
            throw new IllegalArgumentException("Al menos uno de los vértices no existe en el grafo.");
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
        System.out.println("Grafo V1:");
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

    public void eliminarVertice(int vertice) {
        adyacencias.remove(vertice);
        for (List<Integer> adyacenteList : adyacencias.values()) {
            adyacenteList.removeIf(adj -> adj.equals(vertice));
        }
    }

    public boolean existeArista(int origen, int destino) {
        return adyacencias.containsKey(origen) && adyacencias.get(origen).contains(destino);
    }
}

