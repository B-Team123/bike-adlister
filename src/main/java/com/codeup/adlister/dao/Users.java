package com.codeup.adlister.dao;

import com.codeup.adlister.models.User;
import com.codeup.adlister.models.UserAddress;

public interface Users {
    User findByUsername(String username);
    Long insert(User user);
    void update(User user, UserAddress users_address);


}

