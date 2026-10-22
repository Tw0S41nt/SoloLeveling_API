package com.sololeveling.solofit.mapper;

import com.sololeveling.solofit.dto.UserDto;
import com.sololeveling.solofit.model.User;
import jakarta.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-10-22T14:49:13-0400",
    comments = "version: 1.6.3, compiler: Eclipse JDT (IDE) 3.46.200.v20261008-1115, environment: Java 25.0.4.1 (Eclipse Adoptium)"
)
@Component
public class UserDtoMapperImpl implements UserDtoMapper {

    @Override
    public User toEntity(UserDto userDto) throws EntityNotFoundException {
        if ( userDto == null ) {
            return null;
        }

        User user = new User();

        user.setBack( userDto.getBack() );
        user.setBiceps( userDto.getBiceps() );
        user.setCalves( userDto.getCalves() );
        user.setChest( userDto.getChest() );
        user.setDelts( userDto.getDelts() );
        user.setGlutes( userDto.getGlutes() );
        user.setGoal( userDto.getGoal() );
        user.setHamstrings( userDto.getHamstrings() );
        user.setName( userDto.getName() );
        user.setQuads( userDto.getQuads() );
        user.setTraps( userDto.getTraps() );
        user.setUserId( userDto.getUserId() );

        return user;
    }

    @Override
    public UserDto toDto(User user) throws EntityNotFoundException {
        if ( user == null ) {
            return null;
        }

        int userId = 0;
        String name = null;
        String goal = null;
        int chest = 0;
        int biceps = 0;
        int traps = 0;
        int delts = 0;
        int back = 0;
        int quads = 0;
        int glutes = 0;
        int calves = 0;
        int hamstrings = 0;

        if ( user.getUserId() != null ) {
            userId = user.getUserId();
        }
        name = user.getName();
        goal = user.getGoal();
        if ( user.getChest() != null ) {
            chest = user.getChest();
        }
        if ( user.getBiceps() != null ) {
            biceps = user.getBiceps();
        }
        if ( user.getTraps() != null ) {
            traps = user.getTraps();
        }
        if ( user.getDelts() != null ) {
            delts = user.getDelts();
        }
        if ( user.getBack() != null ) {
            back = user.getBack();
        }
        if ( user.getQuads() != null ) {
            quads = user.getQuads();
        }
        if ( user.getGlutes() != null ) {
            glutes = user.getGlutes();
        }
        if ( user.getCalves() != null ) {
            calves = user.getCalves();
        }
        if ( user.getHamstrings() != null ) {
            hamstrings = user.getHamstrings();
        }

        UserDto userDto = new UserDto( userId, name, goal, chest, biceps, traps, delts, back, quads, glutes, calves, hamstrings );

        return userDto;
    }

    @Override
    public List<UserDto> toDtoList(List<User> studentList) throws EntityNotFoundException {
        if ( studentList == null ) {
            return null;
        }

        List<UserDto> list = new ArrayList<UserDto>( studentList.size() );
        for ( User user : studentList ) {
            list.add( toDto( user ) );
        }

        return list;
    }
}
