package com.sololeveling.solofit.controller;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sololeveling.solofit.dto.UserDto;
import com.sololeveling.solofit.mapper.UserDtoMapper;
import com.sololeveling.solofit.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "user", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {

    private final UserDtoMapper userDtoMapper;
    private final UserService userService;

    @GetMapping
    ResponseEntity<List<UserDto>> getAllUsers() {
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

    // change the user's goal. http://localhost:8080/SoloFit/user/1/changeGoal
    @PutMapping("/{id}/changeGoal")
        public ResponseEntity<UserDto> changeUserGoal(@PathVariable int id, @RequestBody Map<String, String> request) {
        String newGoal = request.get("newGoal");
            return new ResponseEntity<>( 
                userDtoMapper.toDto(userService.changeGoal(id, newGoal)), HttpStatus.OK);
    }

    // Add new User.
    @PostMapping ("/add")
    public ResponseEntity<UserDto> addUser(@RequestBody Map<String, String> req){
        String name = req.get("name");
        String goal = req.getOrDefault( "goal", null);

        return new ResponseEntity<>(
            userDtoMapper.toDto(userService.addUser(name, goal)), HttpStatus.CREATED
        );
    }

}
