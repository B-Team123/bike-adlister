package com.codeup.adlister.dao;

import com.codeup.adlister.models.UserAddress;

public interface UsersAddress {
    UserAddress findByCity(String city);
    Long insert(UserAddress usersAddress);
    void update(UserAddress userAddress);
}
