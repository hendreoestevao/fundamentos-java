package org.example.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class AlterarNomePessoa {
    public static void main(String[] args) throws SQLException {

        Scanner sc = new Scanner(System.in);

        System.out.println("Digite o id da pessoa: ");
        int id = sc.nextInt();

        Connection conexao = Conexao.obterConexao();
        PreparedStatement stmt = conexao.prepareStatement("SELECT codigo,nome FROM pessoas WHERE codigo = ?");
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            Pessoa p = new Pessoa(rs.getInt(1), rs.getString(2));
            System.out.println("O nome atual é " + p.getNome());
            sc.nextLine();

            System.out.println("Informe o novo nome: ");
            String novoNome = sc.nextLine();
            stmt.close();
            stmt = conexao.prepareStatement("UPDATE pessoas SET nome = ? WHERE codigo = ?");
            stmt.setString(1, novoNome);
            stmt.setInt(2, id);
            stmt.executeUpdate();
            System.out.println("Pessoa atualizada com sucesso!");

        } else {
            System.out.println("Pessoa não encontrada!");
        }

        conexao.close();
        sc.close();
    }
}
