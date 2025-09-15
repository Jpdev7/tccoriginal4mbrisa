package com.brisa4m.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
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
        System.out.print(checkPasswordHash(req.getPassword(), user.getPassword()));
        if (!checkPasswordHash(req.getPassword(), user.getPassword()))
            throw new RuntimeException("Senha incorreta");

        return new LoginResponse("Usuario logado com sucesso!");
    }

    public LoginResponse createUser(LoginRequest req) {
        UserModel user = userRepository.findByEmail(req.getEmail()).orElse(null);

        if (user != null) {
            throw new RuntimeException("Email ja existe");
        }

        req.setPassword(hashPassword(req.getPassword()));
        UserModel newUser = new UserModel(req.getName(), req.getEmail(), req.getPassword());
        userRepository.save(newUser);

        return new LoginResponse("Usuario criado com sucesso!");
    }

    private boolean checkPasswordHash(String normalPssword, String hashedPassword) {
        BCryptPasswordEncoder bc = new BCryptPasswordEncoder();
        boolean passwordChecked = bc.matches(normalPssword, hashedPassword);

        return passwordChecked;
    }

    private String hashPassword(String normalPssword) {
        String salt = BCrypt.gensalt();
        String hashedPassword = BCrypt.hashpw(normalPssword, salt);

        return hashedPassword;
    }
}