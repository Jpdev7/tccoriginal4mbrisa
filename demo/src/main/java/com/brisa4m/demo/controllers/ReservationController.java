package com.brisa4m.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.brisa4m.demo.dto.ReservationRequest;
import com.brisa4m.demo.models.ReservationModel;
import com.brisa4m.demo.models.RoomModel;
import com.brisa4m.demo.models.UserModel;
import com.brisa4m.demo.repositories.ReservationRepository;
import com.brisa4m.demo.repositories.RoomRepository;
import com.brisa4m.demo.repositories.UserRepository;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/reservations")
public class ReservationController {

    @Autowired
    ReservationRepository reservationRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    RoomRepository roomRepository;

    @GetMapping("")
    public ResponseEntity<List<ReservationModel>> getAllReservations() {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(this.reservationRepository.findAll());
    }

    @PostMapping("/create")
    public ResponseEntity<ReservationModel> createReservation(@RequestBody ReservationRequest req) {

        UserModel user = this.userRepository.findById(req.getId_usuario())
                .orElseThrow(() -> new RuntimeException("Usuario nao encontrado"));

        RoomModel room = this.roomRepository.findById(req.getId_quarto())
                .orElseThrow(() -> new RuntimeException("Quarto nao encontrado"));

        ReservationModel reservationModel = new ReservationModel();
        reservationModel.setUsuario(user);
        reservationModel.setQuarto(room);
        reservationModel.setData_entrada(req.getData_entrada());
        reservationModel.setData_saida(req.getData_saida());
        reservationModel.setStatus("CONFIRMADO");

        this.reservationRepository.save(reservationModel);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(reservationModel);
    }

}
