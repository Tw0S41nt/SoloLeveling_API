package com.example.demo.mapper;

import com.example.demo.dto.UserDto;
import com.example.demo.model.User;
import jakarta.persistence.EntityNotFoundException;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(
    componentModel = "spring")
public interface UserDtoMapper {
    User toEntity(UserDto userDto)throws EntityNotFoundException;
    UserDto toDto(User user)throws EntityNotFoundException;
    List<UserDto> toDtoList(List<User> studentList) throws EntityNotFoundException;
}
