package com.VibutsX.NexivusSpring.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.VibutsX.NexivusSpring.entity.UserEntity;
import com.VibutsX.NexivusSpring.repository.UserRepository;
import com.VibutsX.NexivusSpring.service.UserService;



@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserEntity create(UserEntity entity) {
        entity.setPassword(passwordEncoder.encode(entity.getPassword()));
        return userRepository.save(entity);
    }

    @Override
    public List<UserEntity> getAll() {
        return userRepository.findAll();
    }

    @Override
    public UserEntity getByUsername(String username) {
        return userRepository.findByUsername(username).orElse(null);
    }

    @Override
    public UserEntity update(Long id, UserEntity entity) {
        UserEntity exUser = userRepository.findById(id).orElse(entity);

        if (exUser == null) {
            return null;
        } else {
            entity.setPassword(passwordEncoder.encode(entity.getPassword()));
            exUser.setUsername(entity.getUsername());
            exUser.setPassword(entity.getPassword());
            exUser.setFullname(entity.getFullname());
            exUser.setUserType(entity.getUserType());
            return userRepository.save(exUser);
        }
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public UserEntity getById(Long id) {
        return userRepository.findById(id).orElse(null);
    }
    
}
