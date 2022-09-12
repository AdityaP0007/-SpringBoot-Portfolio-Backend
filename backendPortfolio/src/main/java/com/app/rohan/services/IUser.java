package com.app.rohan.services;

import com.app.rohan.pojos.User;

public interface IUser{

    public User findByEmail(String email);

    public User updateEmailId(String oldEmail, String newEmail);
    public User updateName(String oldEmail, String name);
    public User updatePassword(String oldEmail, String password);

}
