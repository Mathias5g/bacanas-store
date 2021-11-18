package br.com.bacana.store.Dao;

import br.com.bacana.store.Model.Usuario;
import br.com.bacana.store.Utils.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDao {

    private final Connection connection;

    public UsuarioDao() throws SQLException, ClassNotFoundException {
        super();
        connection = DBConnection.getConnection();
    }

    public void CreateUser() throws SQLException {
        System.out.println("CreateUser");
        PreparedStatement preparedStatement = connection.prepareStatement("insert into usuarios values (?, ?, ?)");
    }

    public Usuario ReadUser(String email, String password) throws SQLException {
        Usuario usuario = new Usuario();
        PreparedStatement preparedStatement = connection.prepareStatement("select * from usuarios where email=? AND password=?");
        preparedStatement.setString(1, email);
        preparedStatement.setString(2, password);
        ResultSet rs = preparedStatement.executeQuery();

        if(rs.next()) {
            usuario.setId(rs.getInt("id"));
            usuario.setNome(rs.getString("nome"));
            usuario.setEmail(rs.getString("email"));
        }

        return usuario;
    }

    public void UpdateUser() {
        System.out.println("UpdateUser");
    }

    public void DeleteUser() {
        System.out.println("DeleteUser");
    }
}
