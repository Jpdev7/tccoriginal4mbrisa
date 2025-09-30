package com.brisa4m.demo.models;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.*;

@Entity(name = "Reservas")
public class ReservationModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_reserva;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate data_entrada;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate data_saida;
    private String status;

    // PARA O USO DE FK
    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private UserModel usuario;

    @ManyToOne
    @JoinColumn(name = "id_quarto", nullable = false)
    private RoomModel quarto;

    public ReservationModel() {
    }

    public UserModel getUsuario() {
        return usuario;
    }

    public void setUsuario(UserModel usuario) {
        this.usuario = usuario;
    }

    public RoomModel getQuarto() {
        return quarto;
    }

    public void setQuarto(RoomModel quarto) {
        this.quarto = quarto;
    }

    public Long getId_reserva() {
        return id_reserva;
    }

    public void setId_reserva(Long id_reserva) {
        this.id_reserva = id_reserva;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
