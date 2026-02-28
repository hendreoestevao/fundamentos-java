package org.example.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class ExcluirPessoa {
    public static void main(String[] args) throws SQLException {

        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o id da pessoa que deseja excluir: ");
        int id = sc.nextInt();

        Connection connection = Conexao.obterConexao();
        String sql = "DELETE FROM pessoas WHERE codigo = ?";

        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setInt(1, id);

        if (stmt.executeUpdate() > 0) {
            System.out.println("Pessoa excluida com sucesso!");
        } else {
            System.out.println("Nada feito!");
        }

        connection.close();
        sc.close();


    }
}
