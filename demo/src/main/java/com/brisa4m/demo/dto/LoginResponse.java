package com.brisa4m.demo.dto;

// - LoginResponse: representa a resposta que o sistema devolve após o login (mensagem).

public class LoginResponse {
    private String message;
    // É como uma caixinha fechada chamada message. Só quem tiver a chave (os
    // métodos get e set) pode mexer.

    public LoginResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}