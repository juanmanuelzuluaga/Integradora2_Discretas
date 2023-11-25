package com.example.integradora2_discretas.Juego;

import java.awt.Point;

public class Jugador {
    private Point posicion;

    public Jugador(int x, int y) {
        this.posicion = new Point(x, y);
    }

    public Point getPosicion() {
        return posicion;
    }

    public void moverArriba() {
        posicion.setLocation(posicion.getX(), posicion.getY() - 1);
    }

    public void moverAbajo() {
        posicion.setLocation(posicion.getX(), posicion.getY() + 1);
    }

    public void moverIzquierda() {
        posicion.setLocation(posicion.getX() - 1, posicion.getY());
    }

    public void moverDerecha() {
        posicion.setLocation(posicion.getX() + 1, posicion.getY());
    }

}

