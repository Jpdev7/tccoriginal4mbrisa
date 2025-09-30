package com.brisa4m.demo.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.brisa4m.demo.models.RoomModel;
import com.brisa4m.demo.repositories.RoomRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rooms")
public class RoomController {

    @Autowired
    RoomRepository repository;

    @GetMapping("")
    public ResponseEntity<List<RoomModel>> getAllRooms() {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(this.repository.findAll());
    }

    @PostMapping("/create")
    public ResponseEntity<RoomModel> createRoom(@RequestBody RoomModel roomModel) {
        roomModel.setStatus("LIVRE");
        this.repository.save(roomModel);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(roomModel);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<RoomModel> updateRoom(@RequestBody RoomModel roomModel, @PathVariable Long id) {
        Optional<RoomModel> room = this.repository.findById(id);

        if (room != null) {
            room.get().setStatus(roomModel.getStatus());
            this.repository.save(room.get());
        }

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(room.get());
    }

}
