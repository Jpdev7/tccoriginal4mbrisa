package com.brisa4m.demo.dto;

// - LoginRequest: representa os dados que o usuário envia ao tentar logar (nome, email, senha, etc).

public class LoginRequest {
    private String email;
    private String senha;
    private String cpf;

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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
