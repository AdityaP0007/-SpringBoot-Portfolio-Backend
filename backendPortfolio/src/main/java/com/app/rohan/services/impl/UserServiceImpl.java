package com.app.rohan.services.impl;


import com.app.rohan.pojos.User;
import com.app.rohan.repositories.UserRepository;
import com.app.rohan.services.IUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class UserServiceImpl implements IUser {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User findByEmail(String email) {
        User user = userRepository.findByEmail(email).orElseThrow(()-> new RuntimeException("The user with "+ email+ " not found"));
        return user;
    }

    @Override
    public User updateEmailId(String oldEmail, String newEmail) {
        User user = userRepository.findByEmail(oldEmail).orElseThrow(()-> new RuntimeException("The user with "+ oldEmail+ " not found"));
        user.setEmail(newEmail);
        return user;
    }

    @Override
    public User updateName(String oldEmail, String name) {
        User user = userRepository.findByEmail(oldEmail).orElseThrow(()-> new RuntimeException("The user with "+ oldEmail+ " not found"));
        user.setName(name);
        return user;
    }

    @Override
    public User updatePassword(String oldEmail, String password) {
        User user = userRepository.findByEmail(oldEmail).orElseThrow(()-> new RuntimeException("The user with "+ oldEmail+ " not found"));
        user.setPassword(password);
        return user;
    }


}
