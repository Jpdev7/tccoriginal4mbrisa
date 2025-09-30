package com.brisa4m.demo.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.brisa4m.demo.models.RoomModel;

public interface RoomRepository extends JpaRepository<RoomModel, Long> {
    Optional<RoomModel> findByNumero(Integer numero);

    Optional<RoomModel> findById(Long id_quarto);
}
