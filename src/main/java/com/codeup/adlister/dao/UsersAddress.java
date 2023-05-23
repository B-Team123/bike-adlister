package com.codeup.adlister.dao;

import com.codeup.adlister.models.User;
import com.codeup.adlister.models.UserAddress;

public interface UsersAddress {
    UserAddress findByCity(String city);
    Long insert(UserAddress usersAddress);

    UserAddress findAddressByUserId(Long id);

    void update(UserAddress usersAddress, User user);
}
