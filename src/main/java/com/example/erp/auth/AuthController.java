package com.example.erp.auth;

import com.example.erp.security.JwtService;
import com.example.erp.user.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController @RequestMapping("/api/auth") @RequiredArgsConstructor
public class AuthController {
    private final UserRepository userRepository; private final PasswordEncoder encoder; private final JwtService jwt;

    @PostMapping("/register")
    public String register(@Valid @RequestBody RegisterRequest r, @RequestHeader("X-Tenant-ID") String tenant) {
        userRepository.save(AppUser.builder().username(r.username()).password(encoder.encode(r.password())).role(r.role()).build());
        return jwt.generate(r.username(), tenant, r.role().name());
    }

    @PostMapping("/login")
    public String login(@Valid @RequestBody LoginRequest r, @RequestHeader("X-Tenant-ID") String tenant) {
        AppUser user = userRepository.findByUsername(r.username()).orElseThrow();
        if (!encoder.matches(r.password(), user.getPassword())) throw new RuntimeException("Bad credentials");
        return jwt.generate(user.getUsername(), tenant, user.getRole().name());
    }

    public record RegisterRequest(@NotBlank String username, @NotBlank String password, Role role) {}
    public record LoginRequest(@NotBlank String username, @NotBlank String password) {}
}
