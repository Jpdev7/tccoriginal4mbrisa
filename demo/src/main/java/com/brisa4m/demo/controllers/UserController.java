package com.brisa4m.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.brisa4m.demo.models.UserModel;
import com.brisa4m.demo.repositories.UserRepository;

import jakarta.servlet.http.HttpServletRequest;
import java.util.List;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@RestController
@RequestMapping("/users")
public class UserController {

   // Construtor: mesmo nome da classe (UserController)
   @Autowired
   private UserRepository repository;

   @GetMapping("")
   public ResponseEntity<List<UserModel>> users() {
      return ResponseEntity.status(HttpStatus.CREATED).body(this.repository.findAll());
   }

   @PostMapping("/create")
   public ResponseEntity<UserModel> createUser(@RequestBody UserModel userModel, HttpServletRequest request) {
      var encoder = new BCryptPasswordEncoder();
      var hashedPassword = encoder.encode(userModel.getPassword());
      userModel.setPassword(hashedPassword);
      return ResponseEntity.status(HttpStatus.CREATED).body(userModel);
   }

   @PutMapping("update/{id}")
   public ResponseEntity<String> updateUser(@RequestBody UserModel userModel, HttpServletRequest request,
         @PathVariable String id) {
      return ResponseEntity.status(HttpStatus.CREATED).body(id);
   }

   @DeleteMapping("delete/{id}")
   public ResponseEntity<String> deleteUser(@RequestBody UserModel userModel, HttpServletRequest request,
         @PathVariable String id) {
      return ResponseEntity.status(HttpStatus.ACCEPTED).body(id);
   }
}
