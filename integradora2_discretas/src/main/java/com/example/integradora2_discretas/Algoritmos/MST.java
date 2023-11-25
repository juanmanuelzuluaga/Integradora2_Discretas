package com.example.integradora2_discretas.Algoritmos;

import com.example.integradora2_discretas.Grafo.GrafoV2;

import java.util.*;

public class MST {

    public static Set<Arista> prim(GrafoV2 grafo) throws InterruptedException {
        Set<Arista> mst = new HashSet<>();
        Set<Integer> visitados = new HashSet<>();
        PriorityQueue<Arista> colaPrioridad = new PriorityQueue<>(Comparator.comparingInt(Arista::getPeso));

     
        int inicio = 0;
        for (Arista arista : grafo.obtenerAristasAdyacentes(inicio)) {
            colaPrioridad.add(arista);
        }

        while (!colaPrioridad.isEmpty() && visitados.size() < grafo.obtenerNumeroVertices()) {
            Arista aristaActual = colaPrioridad.poll();

            int verticeOrigen = aristaActual.getOrigen();
            int verticeDestino = aristaActual.getDestino();

            if (visitados.contains(verticeOrigen) && !visitados.contains(verticeDestino)) {
                visitados.add(verticeDestino);
                mst.add(aristaActual);

                for (Arista arista : grafo.obtenerAristasAdyacentes(verticeDestino)) {
                    colaPrioridad.add(arista);
                }
            }
        }

        return mst;
    }

    public static Set<Arista> kruskal(GrafoV2 grafo) {
        Set<Arista> mst = new HashSet<>();
        DisjointSet disjointSet = new DisjointSet(Collections.singleton(grafo.obtenerVertices()));

        List<Arista> aristas = new ArrayList<>(grafo.obtenerAristas());
        aristas.sort(Comparator.comparingInt(Arista::getPeso));

        for (Arista arista : aristas) {
            int conjuntoOrigen = disjointSet.find(arista.getOrigen());
            int conjuntoDestino = disjointSet.find(arista.getDestino());

            if (conjuntoOrigen != conjuntoDestino) {
                mst.add(arista);
                disjointSet.union(conjuntoOrigen, conjuntoDestino);
            }
        }

        return mst;
    }

    public static class Arista {
        private int origen;
        private int destino;
        private int peso;

        public Arista(int origen, int destino, int peso) {
            this.origen = origen;
            this.destino = destino;
            this.peso = peso;
        }

        public int getOrigen() {
            return origen;
        }

        public int getDestino() {
            return destino;
        }

        public int getPeso() {
            return peso;
        }
    }

    private static class DisjointSet {
        private Map<Integer, Integer> padre;

        public DisjointSet(Iterable<Object> elementos) {
            padre = new HashMap<>();
            for (Object elemento : elementos) {
                padre.put((Integer) elemento, (Integer) elemento);
            }
        }

        public int find(int elemento) {
            if (padre.get(elemento) == elemento) {
                return elemento;
            } else {
                int representante = find(padre.get(elemento));
                padre.put(elemento, representante);
                return representante;
            }
        }

        public void union(int conjuntoA, int conjuntoB) {
            int representanteA = find(conjuntoA);
            int representanteB = find(conjuntoB);
            padre.put(representanteA, representanteB);
        }
    }
}

