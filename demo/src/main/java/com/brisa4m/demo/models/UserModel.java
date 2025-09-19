package com.brisa4m.demo.models;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

// EQUIVALENTE A UM MODELS DO PYTHON

@Entity(name = "Usuario")
public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_usuario;
    private String nome;
    private String email;
    private String senha;
    private String nivel_acesso;
    private String cpf;
    private String status_usuario;
    private String telefone;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate data_nascimento;

    public UserModel() {
    }

    public UserModel(String nome, String email, String senha, String nivel_acesso, String cpf, String status_usuario,
            String telefone, LocalDate data_nascimento) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.nivel_acesso = nivel_acesso;
        this.cpf = cpf;
        this.status_usuario = status_usuario;
        this.telefone = telefone;
        this.data_nascimento = data_nascimento;
    }

    public Long getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Long id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNivel_acesso() {
        return nivel_acesso;
    }

    public void setNivel_acesso(String nivel_acesso) {
        this.nivel_acesso = nivel_acesso;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getStatus_usuario() {
        return status_usuario;
    }

    public void setStatus_usuario(String status_usuario) {
        this.status_usuario = status_usuario;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public LocalDate getData_nascimento() {
        return data_nascimento;
    }

    public void setData_nascimento(LocalDate data_nascimento) {
        this.data_nascimento = data_nascimento;
    }
}
