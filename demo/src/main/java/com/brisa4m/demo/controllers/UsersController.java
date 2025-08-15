package com.brisa4m.demo.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.brisa4m.demo.models.UserModel;

import jakarta.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import javax.persistence.Id;



@RestController
@RequestMapping("/users")
public class  UsersController {
    @GetMapping("")
    public String users() {
       return ("users");
     
   }
   @PostMapping("/create")
   public ResponseEntity<String> createUser(@RequestBody UserModel userModel, HttpServletRequest request) {
     return ResponseEntity.status(HttpStatus.CREATED).body("Usuario Entrou na brisa");
  }
   
   @PutMapping("update/{id}")
   public ResponseEntity<String> updateUser(@RequestBody UserModel userModel, HttpServletRequest request, @PathVariable String id) {
     return ResponseEntity.status(HttpStatus.CREATED).body(id);
  }
}
