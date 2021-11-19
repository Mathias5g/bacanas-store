package br.com.bacana.store.Dao;

import br.com.bacana.store.Model.Categoria;
import br.com.bacana.store.Utils.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoriaDao {

    private final Connection connection;

    public CategoriaDao() throws SQLException, ClassNotFoundException {
        super();
        connection = DBConnection.getConnection();
    }

    public void createCategoria(Categoria categoria) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO categorias(nome, linha, faixa_etaria, created_at, updated_at) values(?, ?, ?, ?, ?)");
        preparedStatement.setString(1, categoria.getCategoria());
        preparedStatement.setString(2, categoria.getLinha());
        preparedStatement.setString(3, categoria.getFaixaEtaria());
        preparedStatement.setTimestamp(4, new Timestamp(System.currentTimeMillis()));
        preparedStatement.setTimestamp(5, new Timestamp(System.currentTimeMillis()));

        preparedStatement.executeUpdate();
        preparedStatement.close();
    }

    public Categoria readCategoria(int categoriaId) throws SQLException {
        Categoria categoria = new Categoria();
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM categorias WHERE id = ?");
        preparedStatement.setInt(1, categoriaId);
        ResultSet rs = preparedStatement.executeQuery();

        if(rs.next()) {
            categoria.setCategoria(rs.getString("nome"));
            categoria.setLinha(rs.getString("linha"));
            categoria.setFaixaEtaria(rs.getString("faixa_etaria"));
        }

        return categoria;
    }

    public void updateCategoria(Categoria categoria) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("UPDATE categorias set nome = ?, linha = ?, faixa_etaria = ?, updated_at = ? where id = ?");
        preparedStatement.setString(1, categoria.getCategoria());
        preparedStatement.setString(2, categoria.getLinha());
        preparedStatement.setString(3, categoria.getFaixaEtaria());
        preparedStatement.setTimestamp(4, new Timestamp(System.currentTimeMillis()));
        preparedStatement.setInt(5, categoria.getId());

        preparedStatement.executeUpdate();
        preparedStatement.close();
    }

    public void deleteCategoria(int categoriaId) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM categorias where id = ?");
        preparedStatement.setInt(1, categoriaId);
        preparedStatement.executeUpdate();
        preparedStatement.close();
    }

    public List<Categoria> getAllCategoria() throws SQLException {
        List<Categoria> listaCategoria = new ArrayList<Categoria>();

        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("SELECT * FROM categorias");
        while (rs.next()) {
            Categoria categoria = new Categoria();
            categoria.setId(rs.getInt("id"));
            categoria.setCategoria(rs.getString("nome"));
            categoria.setLinha(rs.getString("linha"));
            categoria.setFaixaEtaria(rs.getString("faixa_etaria"));
            listaCategoria.add(categoria);
        }

        return listaCategoria;
    }
}
