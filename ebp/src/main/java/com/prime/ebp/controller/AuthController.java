package com.prime.ebp.controller;

import com.prime.ebp.model.AuthRequest;
import com.prime.ebp.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

import static com.prime.ebp.mock.UserData.isValidUser;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final JwtUtil jwtUtil;

    // Hardcoded user
    @PostMapping(value = "/login", produces = "application/json")
    public ResponseEntity<?> login(@RequestBody AuthRequest request) {
        if (isValidUser(request.getUsername(), request.getPassword())) {
            String token = jwtUtil.generateToken(request.getUsername());
//            return ResponseEntity.ok().body("Bearer " + token);
            return ResponseEntity.ok(Map.of("token", "Bearer " + token));
        }
        return ResponseEntity.status(401).body("Invalid credentials");
    }
}
