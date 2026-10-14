package com.example.demo.mapper;

import com.example.demo.dto.userDto;
import com.example.demo.model.User;
import jakarta.persistence.EntityNotFoundException;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(
    componentModel = "spring")
public interface userDtoMapper {
    User toEntity(userDto userDto)throws EntityNotFoundException;
    userDto toDto(User user)throws EntityNotFoundException;
    List<userDto> toDtoList(List<User> studentList) throws EntityNotFoundException;
}
