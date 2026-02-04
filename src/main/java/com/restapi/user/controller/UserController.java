package com.restapi.user.controller;

import com.restapi.user.domain.User;
import com.restapi.user.exception.UserNotFoundedException;
import com.restapi.user.service.UserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Iterator;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/users")
    public List<User> getUser(){
        return userService.findAll();
    }

    @GetMapping("/v1/users/{id}")
    public User getUser(@PathVariable Integer id){
        User user = userService.findOne(id);

        if(user == null){
            throw new UserNotFoundedException(String.format("ID[%s] is nout found", id));
        }

        return user;
    }

    @GetMapping("/v2/users/{id}")
    public User getUserV2(@PathVariable Integer id){
        User user = userService.findOne(id);

        if(user == null){
            throw new UserNotFoundedException(String.format("ID[%s] is nout found", id));
        }

        return user;
    }

    @PostMapping("/users")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user){
        User savedUser = userService.save(user);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getUserId())
                .toUri();

        //return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable Integer id){
        User user = userService.deleteById(id);

        if(user == null){
            throw new UserNotFoundedException(String.format("ID[%s] is nout found", id));
        }
    }
}
