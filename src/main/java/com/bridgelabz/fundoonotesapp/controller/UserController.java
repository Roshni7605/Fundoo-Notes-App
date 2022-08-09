package com.bridgelabz.fundoonotesapp.controller;

import com.bridgelabz.fundoonotesapp.dto.UserDTO;
import com.bridgelabz.fundoonotesapp.entity.User;
import com.bridgelabz.fundoonotesapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping
    public Flux<UserDTO> getUser(){
        return service.getUsers();
    }

    @GetMapping("/{id}")
    public Mono<UserDTO> getUserById(@PathVariable String id){
        return service.getUserById(id);
    }

    @PostMapping("/add-user")
    public Mono<UserDTO> addNewUser(@RequestBody Mono<UserDTO> userDTOMono){
        return service.addNewUser(userDTOMono);
    }

    @PutMapping("/update/{id}")
    public Mono<UserDTO> editUserDetails(@PathVariable String id, @RequestBody Mono<UserDTO> userDTOMono){
        return service.editUser(id,userDTOMono);
    }

    @DeleteMapping("/delete/{id}")
    public Mono<Void> deleteUser(@PathVariable String id){
        return service.deleteUser(id);
    }

}
