package com.brisa4m.demo.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.brisa4m.demo.models.UserModel;

public interface UserRepository extends JpaRepository<UserModel, Long> {
    Optional<UserModel> findByEmail(String email);

    Optional<UserModel> findByCpf(String cpf);

    Optional<UserModel> findById(Long id_usuario);
}
