package com.arthur.fr.rugbyvitre.service.impl;

import com.arthur.fr.rugbyvitre.exceptions.NotAllowedToCreateException;
import com.arthur.fr.rugbyvitre.exceptions.UnknownRessourceException;
import com.arthur.fr.rugbyvitre.exceptions.userExceptions.LoginIdentifierException;
import com.arthur.fr.rugbyvitre.exceptions.userExceptions.UserPasswordException;
import com.arthur.fr.rugbyvitre.model.User;
import com.arthur.fr.rugbyvitre.repository.UserRepository;
import com.arthur.fr.rugbyvitre.service.UserServices;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserServices {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public User getById(Integer id) {
        return userRepository.findById(id).orElseThrow(() -> new UnknownRessourceException("No User with this ID"));
    }

    @Override
    public User createUser(User user) {
        if (!this.isNameAlreadyUse(user.getUsername()) ) {
            user.setUsername(user.getUsername());
        } else {
            throw new NotAllowedToCreateException("Username is already user");
        }

        if (this.isPasswordValidate(user.getPassword())) {
            String passwordEncoded = new BCryptPasswordEncoder().encode(user.getPassword());
            user.setPassword(passwordEncoded);
        }else{
            throw new UserPasswordException();
        }
        String passwordEncoded = new BCryptPasswordEncoder().encode("user");
        user.setPassword(passwordEncoded);

        return this.userRepository.save(user);
    }

    @Override
    public User updateUser(User user) {
        User userToUpdate = this.getById(user.getId());

        if ((!this.isNameAlreadyUse(user.getUsername()))||(user.getUsername().equals(userToUpdate.getUsername()))) {
            userToUpdate.setUsername(user.getUsername());
        } else {
            throw new NotAllowedToCreateException("Username is already user");
        }

        if (this.isPasswordValidate(user.getPassword())) {
            String passwordEncoded = new BCryptPasswordEncoder().encode(user.getPassword());
            userToUpdate.setPassword(passwordEncoded);
        }else{
            throw new UserPasswordException();
        }
        return this.userRepository.save(userToUpdate);
    }

    @Override
    public void deleteUser(Integer id) {
        User userToDelete = this.getById(id);
        this.userRepository.delete(userToDelete);
    }

    @Override
    public User getUserByUsernameAndPassword(String username, String password) {
        User user = this.userRepository.findByUsername(username).orElseThrow(() -> new UnknownRessourceException("No user found for the given user/password"));
        if (new BCryptPasswordEncoder().matches(password, user.getPassword())){
            return user;
        }else{
            throw new LoginIdentifierException();
        }
    }

    @Override
    public User getUserByUsername(String username) {
        return this.userRepository.findByUsername(username).orElseThrow(() -> new UnknownRessourceException("No user found for the given user/password"));
    }

    private boolean isNameAlreadyUse(String username){
        return this.userRepository.findByUsername(username).isEmpty();
    }

    private boolean isPasswordValidate(String password){
        return password !=null && password.length()>3;
    }
}
