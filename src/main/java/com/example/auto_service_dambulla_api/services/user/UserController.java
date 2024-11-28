package com.example.auto_service_dambulla_api.services.user;

import com.example.auto_service_dambulla_api.services.user.dtos.UserRegistrationRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class UserController {

    @Autowired
    private UserService userService;

    @CrossOrigin
    // Sign-Up (User Registration)
    @PostMapping("/signup")
    public ResponseEntity<String> registerUser(@RequestBody UserRegistrationRequest request) {
        User user = new User();
        user.setUsername(request.getUsername());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword()); // Password will be encoded by UserService
        user.setRole(request.getRole());
        userService.registerUser(user);
        return new ResponseEntity<>("User registered successfully", HttpStatus.CREATED);
    }

    @CrossOrigin
    @PostMapping("/signin")
    public ResponseEntity<String> signin(@RequestBody UserRegistrationRequest request) {
        UserDetails user = userService.loadUserByUsername(request.getUsername());
        return new ResponseEntity<>(user.getUsername(), HttpStatus.CREATED);
    }

    @CrossOrigin
    // Get User by ID
    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        return userService.getUserById(id)
                .map(user -> new ResponseEntity<>(user, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @CrossOrigin
    // Delete User by ID
    @DeleteMapping("/users/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}
