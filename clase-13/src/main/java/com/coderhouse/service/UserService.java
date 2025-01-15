package com.coderhouse.service;

import com.coderhouse.api.UserRestApi;
import com.coderhouse.entity.User;
import com.coderhouse.interfaces.UserRestInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements UserRestInterface {

    @Autowired
    private UserRestApi userApi;

    @Override
    public List<User> getAllUsers() {
        return userApi.getAllUsers();
    }

    @Override
    public User getUserById(String id) {
        return userApi.getUserById(id);
    }

    @Override
    public User addUser(User user) {
        return userApi.addUser(user);
    }

    @Override
    public User updateUser(User user) {
        return userApi.updateUser(user);
    }

    @Override
    public void deleteUser(String id){
        userApi.deleteUser(id);
    }
}
