package org.example.jdbc;

public class DAOTeste {
    public static void main(String[] args) {
        DAO dao = new DAO();

        String sql = "INSERT INTO pessoas (nome) VALUES (?)";

        System.out.println(dao.incluir(sql, "Incluindo via dao retornando id"));

        dao.close();
    }
}
