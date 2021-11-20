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

    public void createCategoria(Categoria categoria) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO categorias(codigo, nome, linha, faixa_etaria, created_at, updated_at) values(?, ?, ?, ?, ?, ?)");
            preparedStatement.setString(1, categoria.getCodigo());
            preparedStatement.setString(2, categoria.getCategoria());
            preparedStatement.setString(3, categoria.getLinha());
            preparedStatement.setString(4, categoria.getFaixaEtaria());
            preparedStatement.setTimestamp(5, new Timestamp(System.currentTimeMillis()));
            preparedStatement.setTimestamp(6, new Timestamp(System.currentTimeMillis()));

            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Categoria readCategoria(int categoriaId) {
        Categoria categoria = new Categoria();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM categorias WHERE id = ?");
            preparedStatement.setInt(1, categoriaId);
            ResultSet rs = preparedStatement.executeQuery();

            if(rs.next()) {
                categoria.setId(rs.getInt("id"));
                categoria.setCodigo(rs.getString("codigo"));
                categoria.setCategoria(rs.getString("nome"));
                categoria.setLinha(rs.getString("linha"));
                categoria.setFaixaEtaria(rs.getString("faixa_etaria"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return categoria;
    }

    public void updateCategoria(Categoria categoria) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE categorias set codigo = ?, nome = ?, linha = ?, faixa_etaria = ?, updated_at = ? where id = ?");
            preparedStatement.setString(1, categoria.getCodigo());
            preparedStatement.setString(2, categoria.getCategoria());
            preparedStatement.setString(3, categoria.getLinha());
            preparedStatement.setString(4, categoria.getFaixaEtaria());
            preparedStatement.setTimestamp(5, new Timestamp(System.currentTimeMillis()));
            preparedStatement.setInt(6, categoria.getId());

            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteCategoria(int categoriaId) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM categorias where id = ?");
            preparedStatement.setInt(1, categoriaId);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Categoria> getAllCategoria() {
        List<Categoria> listaCategoria = new ArrayList<Categoria>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM categorias");
            while (rs.next()) {
                Categoria categoria = new Categoria();
                categoria.setId(rs.getInt("id"));
                categoria.setCodigo(rs.getString("codigo"));
                categoria.setCategoria(rs.getString("nome"));
                categoria.setLinha(rs.getString("linha"));
                categoria.setFaixaEtaria(rs.getString("faixa_etaria"));
                listaCategoria.add(categoria);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listaCategoria;
    }
}
