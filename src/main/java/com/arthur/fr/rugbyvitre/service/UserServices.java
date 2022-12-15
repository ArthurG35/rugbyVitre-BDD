package com.arthur.fr.rugbyvitre.service;

import com.arthur.fr.rugbyvitre.model.User;

import java.security.NoSuchAlgorithmException;
import java.util.List;

public interface UserServices {
    List<User> getAll();

    User getById(Integer id);

    User createUser(User user) throws NoSuchAlgorithmException;

    User updateUser(User user) throws NoSuchAlgorithmException;

    void deleteUser(Integer id);

    User getUserByUsernameAndPassword(String username, String password);
}
