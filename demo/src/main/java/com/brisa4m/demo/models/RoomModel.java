package com.brisa4m.demo.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name = "Quartos")
public class RoomModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_quarto;
    private Integer numero;
    private Float preco_diaria;
    private String status;

    public RoomModel() {
    }

    public Long getId_quarto() {
        return id_quarto;
    }

    public void setId_quarto(Long id_quarto) {
        this.id_quarto = id_quarto;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Float getPreco_diaria() {
        return preco_diaria;
    }

    public void setPreco_diaria(Float preco_diaria) {
        this.preco_diaria = preco_diaria;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
