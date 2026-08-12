package com.javauserbackend;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // ============================================================
    // GET ALL USERS
    // ============================================================
    @GetMapping
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // ============================================================
    // GET USER BY ID
    // ============================================================
    @GetMapping("/{id}")
    public User getUserById(@PathVariable Integer id) {

        return userRepository.findById(id)
                .orElseThrow(() ->
                        new ResponseStatusException(
                                HttpStatus.NOT_FOUND,
                                "User not found with id: " + id
                        )
                );
    }

    // ============================================================
    // CREATE USER
    // ============================================================
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {

        // Check duplicate username
        if (userRepository.findByUsername(user.getUsername()).isPresent()) {
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT,
                    "Username already exists"
            );
        }

        // Check duplicate email
        if (userRepository.findByEmail(user.getEmail()).isPresent()) {
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT,
                    "Email already exists"
            );
        }

        User savedUser = userRepository.save(user);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(savedUser);
    }

    // ============================================================
    // UPDATE USER
    // ============================================================
    @PutMapping("/{id}")
    public User updateUser(
            @PathVariable Integer id,
            @RequestBody User userDetails) {

        User existingUser = userRepository.findById(id)
                .orElseThrow(() ->
                        new ResponseStatusException(
                                HttpStatus.NOT_FOUND,
                                "User not found with id: " + id
                        )
                );

        // Check username belongs to another user
        userRepository.findByUsername(userDetails.getUsername())
                .ifPresent(user -> {
                    if (!user.getId().equals(id)) {
                        throw new ResponseStatusException(
                                HttpStatus.CONFLICT,
                                "Username already exists"
                        );
                    }
                });

        // Check email belongs to another user
        userRepository.findByEmail(userDetails.getEmail())
                .ifPresent(user -> {
                    if (!user.getId().equals(id)) {
                        throw new ResponseStatusException(
                                HttpStatus.CONFLICT,
                                "Email already exists"
                        );
                    }
                });

        existingUser.setUsername(userDetails.getUsername());
        existingUser.setEmail(userDetails.getEmail());

        return userRepository.save(existingUser);
    }

    // ============================================================
    // DELETE USER
    // ============================================================
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Integer id) {

        User existingUser = userRepository.findById(id)
                .orElseThrow(() ->
                        new ResponseStatusException(
                                HttpStatus.NOT_FOUND,
                                "User not found with id: " + id
                        )
                );

        userRepository.delete(existingUser);

        return ResponseEntity.noContent().build();
    }
}
