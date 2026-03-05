package org.example.javafx.layout;

import javafx.application.Platform;
import javafx.scene.layout.StackPane;

public class TesteStackPane extends StackPane {

    public TesteStackPane() {
        Caixa c1 = new Caixa().comTexto("Caixa 1");
        Caixa c2 = new Caixa().comTexto("Caixa 2");
        Caixa c3 = new Caixa().comTexto("Caixa 3");
        Caixa c4 = new Caixa().comTexto("Caixa 4");
        Caixa c5 = new Caixa().comTexto("Caixa 5");
        Caixa c6 = new Caixa().comTexto("Caixa 6");

        this.getChildren().addAll(c1, c2, c3, c4, c5, c6);

        setOnMouseClicked(event -> {
            if (event.getSceneX() > getScene().getWidth() / 2) {
                getChildren().get(0).toFront();
            } else {
                getChildren().get(5).toBack();
            }

        });

        Thread tr = new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(3000);
                    Platform.runLater(() -> {
                        getChildren().get(0).toFront();
                    });
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        tr.setDaemon(true);
        tr.start();

    }
}
