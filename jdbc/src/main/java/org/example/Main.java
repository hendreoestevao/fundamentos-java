package org.example;

import org.example.jdbc.Conexao;

import java.sql.Connection;

public class Main {
    public static void main(String[] args) throws Exception {

        Connection conn = Conexao.obterConexao();

        System.out.println("Conectado com sucesso!");
        conn.close();
    }
}