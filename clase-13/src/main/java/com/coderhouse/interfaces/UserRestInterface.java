package com.coderhouse.interfaces;

import com.coderhouse.entity.User;

import java.util.List;

public interface UserRestInterface {

    public List<User> getAllUsers();

    public User getUserById(String id);

    public User addUser(User user);

    public User updateUser(User user);

    public void deleteUser(String id);
}
