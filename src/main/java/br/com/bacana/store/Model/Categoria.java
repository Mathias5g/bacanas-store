package br.com.bacana.store.Model;

import java.sql.Timestamp;

public class Categoria {
    private int id;
    private String Codigo;
    private String Categoria;
    private String Linha;
    private String FaixaEtaria;
    private Timestamp Created_At;
    private Timestamp Updated_At;

    public Categoria() {
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

    public String getCategoria() {
        return Categoria;
    }

    public void setCategoria(String categoria) {
        Categoria = categoria;
    }

    public String getLinha() {
        return Linha;
    }

    public void setLinha(String linha) {
        Linha = linha;
    }

    public String getFaixaEtaria() {
        return FaixaEtaria;
    }

    public void setFaixaEtaria(String faixaEtaria) {
        FaixaEtaria = faixaEtaria;
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
