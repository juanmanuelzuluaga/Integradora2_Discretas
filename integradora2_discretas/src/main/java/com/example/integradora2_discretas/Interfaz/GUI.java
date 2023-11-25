package com.example.integradora2_discretas.Interfaz;

import com.example.integradora2_discretas.Juego.Juego;
import com.example.integradora2_discretas.Juego.Jugador;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class GUI extends Application {

    private Juego juego;
    private Jugador jugador;

    public GUI(Juego juego, Jugador jugador) {
        this.juego = juego;
        this.jugador = jugador;
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Laberinto Game");

        Button botonMover = new Button("Mover");
        botonMover.setId("botonMover");

        botonMover.setOnAction(event -> {
            juego.realizarMovimiento();
        });

        VBox root = new VBox();
        root.getChildren().add(botonMover);

        Scene scene = new Scene(root, 300, 200);

        primaryStage.setScene(scene);

        primaryStage.show();
    }
}

