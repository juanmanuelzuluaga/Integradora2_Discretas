package com.example.integradora2_discretas.Juego;

import com.example.integradora2_discretas.Grafo.Grafo;

import java.awt.Point;
import javax.swing.JOptionPane;

public class Juego {
    private Grafo grafoLaberinto;
    private Jugador jugador;
    private Point puntoMeta;

    public Juego(Grafo grafoLaberinto, Jugador jugador, Point puntoMeta) {
        this.grafoLaberinto = grafoLaberinto;
        this.jugador = jugador;
        this.puntoMeta = puntoMeta;
    }

    public void iniciarPartida() {
        JOptionPane.showMessageDialog(null, "Bienvenido al juego de laberinto. ¡Buena suerte!");

        while (!haGanado()) {
            mostrarEstadoLaberinto();

            realizarMovimiento();

            if (haGanado()) {
                JOptionPane.showMessageDialog(null, "¡Felicidades! Has llegado al punto de meta. ¡Has ganado!");
                break;
            }
        }

        JOptionPane.showMessageDialog(null, "¡Gracias por jugar!");
    }

    private boolean haGanado() {
        return jugador.getPosicion().equals(puntoMeta);
    }

    private void mostrarEstadoLaberinto() {
    }

    public void realizarMovimiento() {
        String[] opciones = {"Arriba", "Abajo", "Izquierda", "Derecha"};
        int seleccion = JOptionPane.showOptionDialog(
                null,
                "Selecciona un movimiento:",
                "Movimiento del jugador",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.PLAIN_MESSAGE,
                null,
                opciones,
                opciones[0]
        );

        switch (seleccion) {
            case 0:
                jugador.moverArriba();
                break;
            case 1:
                jugador.moverAbajo();
                break;
            case 2:
                jugador.moverIzquierda();
                break;
            case 3:
                jugador.moverDerecha();
                break;
            default:
        }
    }

}

