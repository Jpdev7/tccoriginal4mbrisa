package com.brisa4m.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.brisa4m.demo.dto.LoginRequest;
import com.brisa4m.demo.dto.LoginResponse;
import com.brisa4m.demo.models.UserModel;
import com.brisa4m.demo.repositories.UserRepository;

@Service
public class AuthService {
    @Autowired
    UserRepository userRepository;

    public LoginResponse login(LoginRequest req) {
        UserModel user = userRepository.findByEmail(req.getEmail())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        if (!checkPasswordHashs(req.getPassword(), user.getPassword()))
            throw new RuntimeException("Senha incorreta");

        return new LoginResponse("Usuario autorizado!");
    }

    private boolean checkPasswordHashs(String normalPssword, String hashedPassword) {
        BCryptPasswordEncoder bc = new BCryptPasswordEncoder();
        boolean passwordChecked = bc.matches(hashedPassword, hashedPassword);

        return passwordChecked;
    }

}