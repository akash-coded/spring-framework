package com.example.ecommerce.usermanagement.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.example.ecommerce.usermanagement.model.User;

@Repository
public class UserRepository {

    private Map<String, User> userMap = new HashMap<>();

    public List<User> findAll() {
        return new ArrayList<>(userMap.values());
    }

    public User findById(String userId) {
        return userMap.get(userId);
    }

    public User save(User user) {
        userMap.put(user.getId(), user);
        return user;
    }

    public void deleteById(String userId) {
        userMap.remove(userId);
    }
}
