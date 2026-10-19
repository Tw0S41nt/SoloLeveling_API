package com.example.demo.controller;

import com.example.demo.dto.UserDto;
import com.example.demo.mapper.UserDtoMapper;
import com.example.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "user", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {

    private final UserDtoMapper userDtoMapper;
    private final UserService userService;

    @GetMapping
    ResponseEntity<List<UserDto>> getAllUsers(){
        return new ResponseEntity<>(
                userDtoMapper.toDtoList(userService.getAllUsers()), HttpStatus.OK);
    }

    @GetMapping(path = "{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable int id) {
        return new ResponseEntity<>(
                userDtoMapper.toDto(userService.findById(id)), HttpStatus.OK);
    }

    @GetMapping(path = "search")
    public ResponseEntity<List<UserDto>> searchUsersByName(@RequestParam String name) {
        return new ResponseEntity<>(
                userDtoMapper.toDtoList(userService.findByName(name)), HttpStatus.OK);
    }
}
