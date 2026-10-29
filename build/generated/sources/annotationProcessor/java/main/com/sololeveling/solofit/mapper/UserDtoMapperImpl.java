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
    date = "2026-10-29T14:36:30-0400",
    comments = "version: 1.6.3, compiler: IncrementalProcessingEnvironment from gradle-java-compiler-worker-9.7.1.jar, environment: Java 17.0.20.1 (Ubuntu)"
)
@Component
public class UserDtoMapperImpl implements UserDtoMapper {

    @Override
    public User toEntity(UserDto userDto) throws EntityNotFoundException {
        if ( userDto == null ) {
            return null;
        }

        User user = new User();

        user.setUserId( userDto.getUserId() );
        user.setName( userDto.getName() );
        user.setGoal( userDto.getGoal() );
        user.setChest( userDto.getChest() );
        user.setBiceps( userDto.getBiceps() );
        user.setTraps( userDto.getTraps() );
        user.setDelts( userDto.getDelts() );
        user.setBack( userDto.getBack() );
        user.setQuads( userDto.getQuads() );
        user.setGlutes( userDto.getGlutes() );
        user.setCalves( userDto.getCalves() );
        user.setHamstrings( userDto.getHamstrings() );

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
