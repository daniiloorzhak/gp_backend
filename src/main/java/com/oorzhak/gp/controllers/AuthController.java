package com.oorzhak.gp.controllers;

import com.oorzhak.gp.dto.AuthenticationDTO;
import com.oorzhak.gp.dto.UserDTO;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {


//    private final JWTUtil jwtUtil;

    @GetMapping("/hello-world")
    public String HelloWorld() {
        return "Hello World";
    }

    @PostMapping("/signin")
    public ResponseEntity.BodyBuilder authenticateUser(@RequestBody @Valid UserDTO userDTO) {
        return ResponseEntity.ok();
    }

    @PostMapping("/signup")
    public ResponseEntity.BodyBuilder authenticateUser(@RequestBody @Valid AuthenticationDTO authenticationDTO) {
        return ResponseEntity.ok();
    }
}
