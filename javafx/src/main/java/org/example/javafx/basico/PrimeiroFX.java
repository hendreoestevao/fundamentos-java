package org.example.javafx.basico;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class PrimeiroFX extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Button botaoA = new Button("A");
        Button botaoB = new Button("B");
        Button botaoC = new Button("C");

        botaoA.setOnAction(e -> {
            System.out.println("A");
        });

        botaoB.setOnAction(e -> {
            System.out.println("B");
        });

        botaoC.setOnAction(e -> {
            System.exit(0);
        });

        HBox vbox = new HBox();
        vbox.setAlignment(Pos.CENTER);
        vbox.setSpacing(10);
        vbox.getChildren().add(botaoA);
        vbox.getChildren().add(botaoB);
        vbox.getChildren().add(botaoC);

        Scene scene = new Scene(vbox, 150, 150);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
