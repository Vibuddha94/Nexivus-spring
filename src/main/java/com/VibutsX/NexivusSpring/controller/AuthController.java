package com.VibutsX.NexivusSpring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.VibutsX.NexivusSpring.dto.AuthReturnDto;
import com.VibutsX.NexivusSpring.dto.LoginDto;
import com.VibutsX.NexivusSpring.entity.UserEntity;
import com.VibutsX.NexivusSpring.security.JwtUtil;
import com.VibutsX.NexivusSpring.service.UserService;

@RestController
public class AuthController {

    @Autowired
    private UserService userService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtUtils;

    @SuppressWarnings("unused")
    @PostMapping("/auth/login")
    public AuthReturnDto login(@RequestBody LoginDto user) {

        List<UserEntity> users = userService.getAll();

        if (users.isEmpty()) {
            // ------------------------Application Configure Purpose------------------------
            UserEntity admin = new UserEntity();
            admin.setUsername("admin");
            admin.setPassword("admin123");
            admin.setFullname("Admin Admin");
            admin.setUserType("admin");
            UserEntity newuser = userService.create(admin);
            newuser = null;
            // -----------------------------------------------------------------------------

            Authentication authentication = authenticationManager
                    .authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));

            SecurityContextHolder.getContext().setAuthentication(authentication);

            String jwtToken = jwtUtils.generateJwtToken(authentication);

            AuthReturnDto dto = new AuthReturnDto();
            dto.setJwtToken(jwtToken);
            dto.setUsertype(userService.getByUsername(user.getUsername()).getUserType());
            return dto;

        } else {

            Authentication authentication = authenticationManager
                    .authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));

            SecurityContextHolder.getContext().setAuthentication(authentication);

            String jwtToken = jwtUtils.generateJwtToken(authentication);

            AuthReturnDto dto = new AuthReturnDto();
            dto.setJwtToken(jwtToken);
            dto.setUsertype(userService.getByUsername(user.getUsername()).getUserType());
            return dto;

        }

    }
}
