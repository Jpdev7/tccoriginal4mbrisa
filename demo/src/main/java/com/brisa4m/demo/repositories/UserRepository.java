package com.brisa4m.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.brisa4m.demo.models.UserModel;

public interface UserRepository extends JpaRepository<UserModel, Long> {
}
