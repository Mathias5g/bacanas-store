package br.com.bacana.store.Model;

import java.sql.Timestamp;

public class Usuario {
    private int id;
    private String Nome;
    private String Email;
    private String Password;
    private Timestamp Created_At;
    private Timestamp Updated_At;

    public Usuario() {
        super();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
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
