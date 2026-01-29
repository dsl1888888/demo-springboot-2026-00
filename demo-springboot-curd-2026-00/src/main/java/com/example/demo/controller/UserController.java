package com.example.demo.controller;

import com.example.demo.model.User;
import org.springframework.web.bind.annotation.*;
import java.util.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.Data;
import org.springframework.web.bind.annotation.*;

import java.util.*;

import com.example.demo.model.User;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/users")
@Tag(name = "User Management", description = "CRUD operations for Users")
public class UserController {

    // Removed final
    private Map<Long, User> users = new HashMap<>();


    @PostMapping("/init")
    @Operation(summary = "Initialize 20 dummy users")
    public List<User> initTwentyUsers() {
        List<User> createdUsers = new ArrayList<>();

        for (int i = 1; i <= 20; i++) {
            User user = new User();
            user.setId((long) i);
            user.setName("User_" + i);
            user.setEmail("user" + i + "@example.com");

            users.put(user.getId(), user);
            createdUsers.add(user);
        }

        return createdUsers;
    }


    @PostMapping
    @Operation(summary = "Create a new user")
    public User createUser(@RequestBody User user) {
        // Ensure user and ID are not null to avoid crashes
        if (user != null && user.getId() != null) {
            users.put(user.getId(), user);
        }
        return user;
    }

    @GetMapping
    @Operation(summary = "Get all users")
    public List<User> getAllUsers() {
        return new ArrayList<>(users.values());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get user by ID")
    public User getUserById(@PathVariable Long id) {
        return users.get(id);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update an existing user")
    public User updateUser(@PathVariable Long id, @RequestBody User userDetails) {
        User user = users.get(id);
        if (user != null) {
            // These require Lombok @Data to work on the User class
            user.setName(userDetails.getName());
            user.setEmail(userDetails.getEmail());
            users.put(id, user);
        }
        return user;
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a user")
    public String deleteUser(@PathVariable Long id) {
        users.remove(id);
        return "User " + id + " deleted.";
    }
}
