package org.example.jdbc;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class Conexao {

    private static final String PROPERTIES_FILE = "/config.properties";
    private static String url;
    private static String usuario;
    private static String senha;

    static {
        carregarPropriedades();
    }

    private static void carregarPropriedades() {
        try (InputStream input = Conexao.class.getResourceAsStream(PROPERTIES_FILE)) {

            if (input == null) {
                throw new RuntimeException("Arquivo config.properties não encontrado.");
            }

            Properties properties = new Properties();
            properties.load(input);

            url = properties.getProperty("banco.url");
            usuario = properties.getProperty("banco.usuario");
            senha = properties.getProperty("banco.senha");

        } catch (IOException e) {
            throw new RuntimeException("Erro ao carregar arquivo de propriedades.", e);
        }
    }

    public static Connection obterConexao() throws SQLException {
        return DriverManager.getConnection(url, usuario, senha);
    }
}