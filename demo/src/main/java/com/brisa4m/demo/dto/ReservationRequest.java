package com.brisa4m.demo.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ReservationRequest {
    private Long id_usuario;
    private Long id_quarto;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate data_entrada;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate data_saida;

    public Long getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Long id_usuario) {
        this.id_usuario = id_usuario;
    }

    public Long getId_quarto() {
        return id_quarto;
    }

    public void setId_quarto(Long id_quarto) {
        this.id_quarto = id_quarto;
    }

    public LocalDate getData_entrada() {
        return data_entrada;
    }

    public void setData_entrada(LocalDate data_entrada) {
        this.data_entrada = data_entrada;
    }

    public LocalDate getData_saida() {
        return data_saida;
    }

    public void setData_saida(LocalDate data_saida) {
        this.data_saida = data_saida;
    }

}
