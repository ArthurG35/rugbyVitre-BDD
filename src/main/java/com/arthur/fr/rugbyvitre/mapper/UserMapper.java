package com.arthur.fr.rugbyvitre.mapper;

import com.arthur.fr.rugbyvitre.api.dto.UserDto;
import com.arthur.fr.rugbyvitre.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface UserMapper {
    @Mapping(target = "id", source = "id")
    UserDto mapToDto(User user);

    @Mapping(target = "id", source = "id")
    User mapToModel(UserDto userDto);
}
