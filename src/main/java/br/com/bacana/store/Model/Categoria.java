package br.com.bacana.store.Model;

public class Categoria {
    private int id;
    private String Codigo;
    private String Categoria;
    private String FaixaEtaria;

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

    public String getCategoria() {
        return Categoria;
    }

    public void setCategoria(String categoria) {
        Categoria = categoria;
    }

    public String getFaixaEtaria() {
        return FaixaEtaria;
    }

    public void setFaixaEtaria(String faixaEtaria) {
        FaixaEtaria = faixaEtaria;
    }
}
