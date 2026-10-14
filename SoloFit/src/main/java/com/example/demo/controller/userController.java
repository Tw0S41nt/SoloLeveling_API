package com.example.demo.controller;

import com.example.demo.mapper.userDtoMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "user")
public class userController {

    private final userDtoMapper userDtoMapper;

}
