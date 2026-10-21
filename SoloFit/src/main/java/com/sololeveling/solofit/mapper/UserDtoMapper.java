package com.sololeveling.solofit.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.sololeveling.solofit.dto.UserDto;
import com.sololeveling.solofit.model.User;

import jakarta.persistence.EntityNotFoundException;

@Mapper(componentModel = "spring")
public interface UserDtoMapper {
    User toEntity(UserDto userDto) throws EntityNotFoundException;

    UserDto toDto(User user) throws EntityNotFoundException;

    List<UserDto> toDtoList(List<User> studentList) throws EntityNotFoundException;
}
