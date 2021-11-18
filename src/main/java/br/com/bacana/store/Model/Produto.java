package br.com.bacana.store.Model;

import java.sql.Timestamp;

public class Produto {
    private int id;
    private String Codigo;
    private String Produto;
    private String Descricao;
    private String ImagemB64;
    private Integer Categoria;
    private Double Preco;
    private Timestamp Created_At;
    private Timestamp Updated_At;

    public Produto() {
        super();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodigo() {
        return Codigo;
    }

    public void setCodigo(String codigo) {
        Codigo = codigo;
    }

    public String getProduto() {
        return Produto;
    }

    public void setProduto(String produto) {
        Produto = produto;
    }

    public String getDescricao() {
        return Descricao;
    }

    public void setDescricao(String descricao) {
        Descricao = descricao;
    }

    public String getImagemB64() {
        return ImagemB64;
    }

    public void setImagemB64(String imagemB64) {
        ImagemB64 = imagemB64;
    }

    public Integer getCategoria() {
        return Categoria;
    }

    public void setCategoria(Integer categoria) {
        Categoria = categoria;
    }

    public Double getPreco() {
        return Preco;
    }

    public void setPreco(Double preco) {
        Preco = preco;
    }

    public Timestamp getCreated_At() {
        return Created_At;
    }

    public void setCreated_At(Timestamp created_At) {
        Created_At = created_At;
    }

    public Timestamp getUpdated_At() {
        return Updated_At;
    }

    public void setUpdated_At(Timestamp updated_At) {
        Updated_At = updated_At;
    }
}
