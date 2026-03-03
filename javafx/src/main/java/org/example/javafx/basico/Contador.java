package org.example.javafx.basico;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.concurrent.atomic.AtomicInteger;

public class Contador extends Application {
    private int contador = 1;
    private Label labelNumero;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        Label labelTitulo = new Label("Contador");
        labelTitulo.getStyleClass().add("titulo");

        labelNumero = new Label(String.valueOf(contador));
        labelNumero.getStyleClass().add("numero");


        Button botaoAcrescimo = new Button("+");
        botaoAcrescimo.getStyleClass().add("botoes");

        botaoAcrescimo.setOnAction(e -> {
           contador++;
            labelNumero.setText(String.valueOf(contador));
        });

        Button botaoRemover = new Button("-");
        botaoRemover.getStyleClass().add("botoes");

        botaoRemover.setOnAction(e -> {
            contador--;
            labelNumero.setText(String.valueOf(contador));
        });

        HBox boxBotoes = new HBox();
        boxBotoes.setAlignment(Pos.CENTER);
        boxBotoes.setSpacing(10);
        boxBotoes.getChildren().add(botaoAcrescimo);
        boxBotoes.getChildren().add(botaoRemover);

        VBox boxPrincipal = new VBox();
        boxPrincipal.getStyleClass().add("conteudo");
        boxPrincipal.setAlignment(Pos.CENTER);
        boxPrincipal.setSpacing(10);
        boxPrincipal.getChildren().addAll(labelTitulo);
        boxPrincipal.getChildren().addAll(labelNumero);
        boxPrincipal.getChildren().addAll(boxBotoes);

        String caminhoDoCss =  getClass().getResource("/org/example/javafx/basico/Contador.css").toExternalForm();
        Scene scenePrincipal = new Scene(boxPrincipal, 400,400);
        scenePrincipal.getStylesheets().add(caminhoDoCss);
        scenePrincipal.getStylesheets().add("https://fonts.googleapis.com/css?family=Oswald");
        primaryStage.setScene(scenePrincipal);


        primaryStage.show();
    }
}
