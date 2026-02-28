package org.example.jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CriarTabelaPessoas {
    public static void main(String[] args) throws SQLException {
        Connection conexao = Conexao.obterConexao();

        String sql = "CREATE TABLE  pessoas(" + "codigo INT AUTO_INCREMENT PRIMARY KEY," + "nome VARCHAR(80) NOT NULL " + ")";
        Statement stmt = conexao.createStatement();
        stmt.executeUpdate(sql);

        System.out.println("Tabela de pessoas criada com sucesso!");
        conexao.close();
    }
}
