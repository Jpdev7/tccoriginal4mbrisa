package com.brisa4m.demo.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.brisa4m.demo.models.UserModel;
import com.brisa4m.demo.repositories.UserRepository;

import jakarta.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

   private final UserRepository repository;

   // Construtor: mesmo nome da classe (UserController)
   public UserController(UserRepository repository) {
      this.repository = repository;
   }

   @GetMapping("")
   public ResponseEntity<List<UserModel>> users() {
      return ResponseEntity.status(HttpStatus.CREATED).body(this.repository.findAll());
   }

   @PostMapping("/create")
   public ResponseEntity<String> createUser(@RequestBody UserModel userModel, HttpServletRequest request) {
      return ResponseEntity.status(HttpStatus.CREATED).body("Usuario Entrou na brisa");
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
