package org.example.service;

import org.example.models.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserPool {
    private final List<User> users = new ArrayList<>();
    private final Map<String, User> userIdAndUserMap = new HashMap<>();

    public UserPool() {
    }

    public List<User> getUsers() {
        return users;
    }

    public User getUserById(String id) {
        return userIdAndUserMap.get(id);
    }

    public void addUser(User user) {
        if(userIdAndUserMap.containsKey(user.getId())) {
            throw new IllegalArgumentException();
        } else {
            users.add(user);
            userIdAndUserMap.put(user.getId(), user);
        }
    }
}
