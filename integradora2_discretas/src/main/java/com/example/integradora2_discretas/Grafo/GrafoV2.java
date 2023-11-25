package com.example.integradora2_discretas.Grafo;

import com.example.integradora2_discretas.Algoritmos.MST;

import java.util.*;

public class GrafoV2 {
    private Set<Integer> vertices;
    private Set<Arista> aristas;

    public GrafoV2() {
        this.vertices = new HashSet<>();
        this.aristas = new HashSet<>();
    }

    public void agregarVertice(int vertice) {
        vertices.add(vertice);
    }

    public void agregarArista(int origen, int destino) {
        if (!vertices.contains(origen) || !vertices.contains(destino)) {
            throw new IllegalArgumentException("Al menos uno de los vértices no existe en el grafo.");
        }
        Arista arista = new Arista(origen, destino);
        aristas.add(arista);
    }

    public Set<Integer> obtenerAdyacencias(int vertice) {
        Set<Integer> adyacentes = new HashSet<>();
        for (Arista arista : aristas) {
            if (arista.tieneVertice(vertice)) {
                adyacentes.add(arista.getOtroVertice(vertice));
            }
        }
        return adyacentes;
    }

    public int obtenerNumeroVertices() {
        return vertices.size();
    }

    public int obtenerNumeroAristas() {
        return aristas.size();
    }

    public void imprimirGrafo() {
        System.out.println("Grafo V2:");
        for (Arista arista : aristas) {
            System.out.println(arista);
        }
    }

    // Métodos adicionales para pruebas unitarias
    public void eliminarVertice(int vertice) {
        vertices.remove(vertice);
        aristas.removeIf(a -> a.contieneVertice(vertice));
    }

    public boolean existeArista(int origen, int destino) {
        return aristas.contains(new Arista(origen, destino));
    }

    public int[] obtenerVertices() {
        return new int[0];
    }

    public Integer obtenerPesoArista(int actual, int vecino) {
        return null;
    }

    public MST.Arista[] obtenerAristasAdyacentes(int inicio) {
        return new MST.Arista[0];
    }

    public int obtenerAristas() {
        return 0;
    }

    private static class Arista {
        private int vertice1;
        private int vertice2;

        public Arista(int vertice1, int vertice2) {
            this.vertice1 = vertice1;
            this.vertice2 = vertice2;
        }

        public boolean contieneVertice(int vertice) {
            return vertice1 == vertice || vertice2 == vertice;
        }

        public boolean tieneVertice(int vertice) {
            return vertice1 == vertice || vertice2 == vertice;
        }

        public int getOtroVertice(int vertice) {
            if (vertice1 == vertice) {
                return vertice2;
            } else if (vertice2 == vertice) {
                return vertice1;
            } else {
                throw new IllegalArgumentException("El vértice no pertenece a la arista.");
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Arista arista = (Arista) o;
            return (vertice1 == arista.vertice1 && vertice2 == arista.vertice2) ||
                    (vertice1 == arista.vertice2 && vertice2 == arista.vertice1);
        }

        @Override
        public int hashCode() {
            return Objects.hash(vertice1, vertice2);
        }

        @Override
        public String toString() {
            return "(" + vertice1 + " - " + vertice2 + ")";
        }
    }
}

