package com.example.demo.controller;

import com.example.demo.dto.userDto;
import com.example.demo.mapper.userDtoMapper;
import com.example.demo.model.User;
import com.example.demo.service.userService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "user", produces = MediaType.APPLICATION_JSON_VALUE)
public class userController {

    private final userDtoMapper userDtoMapper;
    private final userService userService;

    @GetMapping
    ResponseEntity<List<userDto>> getAllUsers(){
        return new ResponseEntity<>(
                userDtoMapper.toDtoList(userService.getAllUsers()), HttpStatus.OK);
    }

    @GetMapping(path = "{id}")
    public ResponseEntity<userDto> getUserById(@PathVariable int id) {
        return new ResponseEntity<>(
                userDtoMapper.toDto(userService.findById(id)), HttpStatus.OK);
    }

    @GetMapping(path = "search")
    public ResponseEntity<List<userDto>> searchUsersByName(@RequestParam String name) {
        return new ResponseEntity<>(
                userDtoMapper.toDtoList(userService.findByName(name)), HttpStatus.OK);
    }
}
