package org.example.javafx.fxml;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController {

    @FXML
    private TextField campoUsuario;

    @FXML
    private PasswordField campoSenha;

    @FXML
    public void entrar() {

        String usuario = campoUsuario.getText();
        String senha = campoSenha.getText();

        if (usuario.equals("admin") && senha.equals("admin")) {

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Login");
            alert.setHeaderText(null);
            alert.setContentText("Login correto ✅");
            alert.showAndWait();

        } else {

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro");
            alert.setHeaderText(null);
            alert.setContentText("Login inválido ❌");
            alert.showAndWait();

        }
    }
}