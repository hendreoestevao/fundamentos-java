package org.example.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static java.sql.Statement.RETURN_GENERATED_KEYS;

public class DAO {

    private Connection connection;

    public int incluir(String sql, Object... params) {
        try {
            PreparedStatement stmt = getConnection().prepareStatement(sql, RETURN_GENERATED_KEYS);
            adicionarAtributos(stmt, params);

            if (stmt.executeUpdate() > 0) {
                ResultSet rs = stmt.getGeneratedKeys();

                if (rs.next()) {
                    return rs.getInt(1);
                }
            }
            return -1;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void close() {
        try {
            getConnection().close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            connection = null;
        }
    }


    private void adicionarAtributos(PreparedStatement stmt, Object[] objects) throws SQLException {

        int i = 1;
        for (Object object : objects) {
            if (object instanceof String) {
                stmt.setString(i, (String) object);
            } else if (object instanceof Integer) {
                stmt.setInt(i, (Integer) object);
            }
            i++;
        }
    }

    private Connection getConnection() throws SQLException {

        if (connection != null && !connection.isClosed()) {
            return connection;
        }

        connection = Conexao.obterConexao();
        return connection;
    }
}
