package com.brisa4m.demo.dto;

import java.time.LocalDate;

// - LoginRequest: representa os dados que o usuário envia ao tentar logar (nome, email, senha, etc).

public class LoginRequest {
    private String nome;
    private String email;
    private String senha;
    private String nivel_acesso;
    private String cpf;
    private String status_usuario;
    private String telefone;
    private LocalDate data_nascimento;

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

    public String getNivelAcesso() {
        return nivel_acesso;
    }

    public void setNivelAcesso(String nivel_acesso) {
        this.nivel_acesso = nivel_acesso;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getStatusUsuario() {
        return status_usuario;
    }

    public void setStatusUsuario(String status_usuario) {
        this.status_usuario = status_usuario;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public LocalDate getDataNascimento() {
        return data_nascimento;
    }

    public void setDataNascimento(LocalDate data_nascimento) {
        this.data_nascimento = data_nascimento;
    }
}
