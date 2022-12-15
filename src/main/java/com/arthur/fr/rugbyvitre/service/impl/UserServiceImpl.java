package com.arthur.fr.rugbyvitre.service.impl;

import com.arthur.fr.rugbyvitre.exceptions.NotAllowedToCreateException;
import com.arthur.fr.rugbyvitre.exceptions.UnknownRessourceException;
import com.arthur.fr.rugbyvitre.exceptions.userExceptions.LoginIdentifierException;
import com.arthur.fr.rugbyvitre.exceptions.userExceptions.UserGrantException;
import com.arthur.fr.rugbyvitre.model.User;
import com.arthur.fr.rugbyvitre.repository.UserRepository;
import com.arthur.fr.rugbyvitre.service.UserServices;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Map;

import static com.arthur.fr.rugbyvitre.security.Hashing.checkPassword;
import static com.arthur.fr.rugbyvitre.security.Hashing.passwordHash;

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
    public User createUser(User user) throws NoSuchAlgorithmException {
        if (this.isNameAlreadyUse(user.getUsername())) {
            user.setUsername(user.getUsername());
        } else {
            throw new NotAllowedToCreateException("Username is already user");
        }
        Map<String, String> passwordUser = passwordHash(user.getPassword());
        user.setPassword(passwordUser.get("password"));
        user.setKey(passwordUser.get("key"));
        return this.userRepository.save(user);
    }

    @Override
    public User updateUser(User user) throws NoSuchAlgorithmException {
        User userToUpdate = this.getById(user.getId());

        if ((this.isNameAlreadyUse(user.getUsername()))||(user.getUsername().equals(userToUpdate.getUsername()))) {
            Map<String, String> passwordUser = passwordHash(user.getPassword());
            userToUpdate.setPassword(passwordUser.get("password"));
            userToUpdate.setKey(passwordUser.get("key"));
        } else {
            throw new NotAllowedToCreateException("Username is already user");
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
        System.out.println(password +' '+ user.getPassword() +' '+ user.getKey());
        if(checkPassword(password, user.getKey(), user.getPassword())) {
            return user;
        } else {
            throw new LoginIdentifierException("Wrong password");
        }
    }

    private boolean isNameAlreadyUse(String username){
        return this.userRepository.findByUsername(username).isEmpty();
    }
}
