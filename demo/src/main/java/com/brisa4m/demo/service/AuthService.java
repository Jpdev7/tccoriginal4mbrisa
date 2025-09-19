package com.brisa4m.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.brisa4m.demo.dto.LoginRequest;
import com.brisa4m.demo.dto.LoginResponse;
import com.brisa4m.demo.models.UserModel;
import com.brisa4m.demo.repositories.UserRepository;

@Service
// É como uma etiqueta dizendo: "Ei Spring, essa classe é um serviço, use-a para
// lógica do sistema".
// Em resumo: Service = "cérebro" da aplicação, onde mora a lógica.
public class AuthService {
    // Classe responsável pela regra de negócio do login.
    @Autowired
    UserRepository userRepository;
    String errorMessage = "Usuário ou senha incorretos";

    public LoginResponse login(LoginRequest req) {
        UserModel user;
        if (req.getEmail() != null) {
            user = userRepository.findByEmail(req.getEmail())
                    .orElseThrow(() -> new RuntimeException(errorMessage));
        } else {
            user = userRepository.findByCpf(req.getCpf())
                    .orElseThrow(() -> new RuntimeException(errorMessage));
        }

        if (!checkPasswordHash(req.getSenha(), user.getSenha()))
            throw new RuntimeException(errorMessage);

        return new LoginResponse("Usuario logado com sucesso!");
    }

    private boolean checkPasswordHash(String normalPssword, String hashedPassword) {
        BCryptPasswordEncoder bc = new BCryptPasswordEncoder();
        boolean passwordChecked = bc.matches(normalPssword, hashedPassword);

        return passwordChecked;
    }
}