package com.arthur.fr.rugbyvitre.api.v1;

import com.arthur.fr.rugbyvitre.api.dto.UserDto;
import com.arthur.fr.rugbyvitre.exceptions.NotAllowedToCreateException;
import com.arthur.fr.rugbyvitre.exceptions.NotAllowedToDeleteException;
import com.arthur.fr.rugbyvitre.exceptions.UnknownRessourceException;
import com.arthur.fr.rugbyvitre.mapper.UserMapper;
import com.arthur.fr.rugbyvitre.service.UserServices;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.net.URI;
import java.security.NoSuchAlgorithmException;
import java.util.List;

@RestController
@RequestMapping("/v1/users")
public class UserApi {
    private final UserServices userServices;

    private final UserMapper userMapper;

    @Autowired
    public UserApi(UserServices userServices, UserMapper userMapper) {
        this.userServices = userServices;
        this.userMapper = userMapper;
    }

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<UserDto>> getAll() {
        return ResponseEntity.ok(
                this.userServices.getAll().stream()
                        .map(this.userMapper::mapToDto)
                        .toList());
    }

    @GetMapping(value = "/{id}",produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<UserDto> getById(@PathVariable Integer id ) {
        try {
            return ResponseEntity.ok(this.userMapper
                    .mapToDto(this.userServices.getById(id)));
        } catch (UnknownRessourceException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

    @PostMapping(
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.TEXT_PLAIN_VALUE}
    )
    public ResponseEntity<UserDto> createUser(@RequestBody final UserDto userDto) throws NoSuchAlgorithmException {

        UserDto userDtoResponse =
                this.userMapper.mapToDto(
                        this.userServices.createUser(
                                this.userMapper.mapToModel(userDto)
                        ));

        return ResponseEntity
                .created(URI.create("/v1/users/" + userDtoResponse.getId()))
                .body(userDtoResponse);
    }

    @PutMapping(path = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE}, consumes = {MediaType.APPLICATION_JSON_VALUE} )
    @Operation(summary = "updateUser")
    public ResponseEntity<UserDto> updateUser(@RequestBody UserDto user, @PathVariable Integer id){
        try{
            user.setId(id);
            UserDto userDto= userMapper.mapToDto(userServices.updateUser(userMapper.mapToModel(user)));
            return ResponseEntity.ok(userDto);
        }catch (NotAllowedToCreateException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> deleteArticle(@PathVariable final Integer id) {
        try {
            this.userServices.deleteUser(id);
            return ResponseEntity.noContent().build();
        } catch (UnknownRessourceException ure) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, ure.getMessage());
        } catch (NotAllowedToDeleteException ex) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, ex.getMessage());
        }
    }


    @GetMapping(path = "/login", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<UserDto> login(@RequestParam String username, @RequestParam String password) {
        try {
            return ResponseEntity.ok(
                    userMapper.mapToDto(userServices.getUserByUsernameAndPassword(username, password))
            );
        } catch (UnknownRessourceException ure) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, ure.getMessage());
        }
    }

}
