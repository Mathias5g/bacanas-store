package br.com.bacana.store.Dao;

import br.com.bacana.store.Model.Categoria;
import br.com.bacana.store.Model.Produto;
import br.com.bacana.store.Utils.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDao {

    private final Connection connection;

    public ProdutoDao() throws SQLException, ClassNotFoundException {
        super();
        connection = DBConnection.getConnection();
    }

    public void createProduto(Produto produto) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO produtos(codigo, produto, descricao, imagemB64, preco, categoria_id, created_at, updated_at) values(?, ?, ?, ?, ?, ?, ?, ?)");
            preparedStatement.setString(1, produto.getCodigo());
            preparedStatement.setString(2, produto.getProduto());
            preparedStatement.setString(3, produto.getDescricao());
            preparedStatement.setString(4, produto.getImagemB64());
            preparedStatement.setDouble(5, produto.getPreco());
            preparedStatement.setInt(6, produto.getCategoria());
            preparedStatement.setTimestamp(7, new Timestamp(System.currentTimeMillis()));
            preparedStatement.setTimestamp(8, new Timestamp(System.currentTimeMillis()));

            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Produto readProduto(int produtoId) {
        Produto produto = new Produto();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM produtos WHERE id = ?");
            preparedStatement.setInt(1, produtoId);
            ResultSet rs = preparedStatement.executeQuery();

            if(rs.next()) {
                produto.setId(rs.getInt("id"));
                produto.setCodigo(rs.getString("codigo"));
                produto.setProduto(rs.getString("produto"));
                produto.setDescricao(rs.getString("descricao"));
                produto.setImagemB64(rs.getString("imagemB64"));
                produto.setPreco(rs.getDouble("preco"));
                produto.setCategoria(rs.getInt("categoria_id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return produto;
    }

    public void updateProduto(Produto produto) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE produtos set codigo = ?, produto = ?, descricao = ?, imagemB64 = ?, preco = ?, categoria_id = ?, updated_at = ? where id = ?");
            preparedStatement.setString(1, produto.getCodigo());
            preparedStatement.setString(2, produto.getProduto());
            preparedStatement.setString(3, produto.getDescricao());
            preparedStatement.setString(4, produto.getImagemB64());
            preparedStatement.setDouble(5, produto.getPreco());
            preparedStatement.setInt(6, produto.getCategoria());
            preparedStatement.setTimestamp(7, new Timestamp(System.currentTimeMillis()));
            preparedStatement.setInt(8, produto.getId());

            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteProduto(int categoriaId) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM produtos where id = ?");
            preparedStatement.setInt(1, categoriaId);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Produto> getAllProduto() {
        List<Produto> listaProdutos = new ArrayList<Produto>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM produtos");
            while (rs.next()) {
                Produto produto = new Produto();
                produto.setId(rs.getInt("id"));
                produto.setCodigo(rs.getString("codigo"));
                produto.setProduto(rs.getString("produto"));
                produto.setDescricao(rs.getString("descricao"));
                produto.setImagemB64(rs.getString("imagemB64"));
                produto.setPreco(rs.getDouble("preco"));
                produto.setCategoria(rs.getInt("categoria_id"));
                listaProdutos.add(produto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listaProdutos;
    }
}
