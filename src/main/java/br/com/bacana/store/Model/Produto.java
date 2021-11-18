package br.com.bacana.store.Model;

public class Produto {
    private int id;
    private String Codigo;
    private String Produto;
    private String Descricao;
    private String ImagemB64;
    private String Categoria;
    private Double Preco;

    public Produto(String codigo, String produto, String descricao) {
        Codigo = codigo;
        Produto = produto;
        Descricao = descricao;
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

    public String getCategoria() {
        return Categoria;
    }

    public void setCategoria(String categoria) {
        Categoria = categoria;
    }

    public Double getPreco() {
        return Preco;
    }

    public void setPreco(Double preco) {
        Preco = preco;
    }
}
