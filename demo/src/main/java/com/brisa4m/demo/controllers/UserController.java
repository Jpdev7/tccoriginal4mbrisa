package com.brisa4m.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.brisa4m.demo.models.UserModel;
import com.brisa4m.demo.repositories.UserRepository;

import java.util.List;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@RestController
@RequestMapping("/users")
public class UserController {

   @Autowired
   private UserRepository repository;

   @GetMapping("")
   public ResponseEntity<List<UserModel>> users() {
      return ResponseEntity.status(HttpStatus.CREATED).body(this.repository.findAll());
   }

   @PostMapping("/create")
   public ResponseEntity<UserModel> createUser(@RequestBody UserModel userModel) {
      var encoder = new BCryptPasswordEncoder();
      var hashedPassword = encoder.encode(userModel.getSenha());

      userModel.setSenha(hashedPassword);
      userModel.setNivel_acesso("USER");
      userModel.setStatus_usuario("ATIVO");
      repository.save(userModel);
      return ResponseEntity.status(HttpStatus.CREATED).body(userModel);
   }

   @PutMapping("update/{id}")
   public ResponseEntity<String> updateUser(@RequestBody UserModel userModel,
         @PathVariable String id) {
      return ResponseEntity.status(HttpStatus.CREATED).body(id);
   }

   @DeleteMapping("delete/{id}")
   public ResponseEntity<String> deleteUser(@RequestBody UserModel userModel,
         @PathVariable String id) {
      return ResponseEntity.status(HttpStatus.ACCEPTED).body(id);
   }
}
