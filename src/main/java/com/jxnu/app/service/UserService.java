package com.jxnu.app.service;

import com.jxnu.app.model.User;

import java.util.List;

/**
 * Created by puchunwei on 16/5/1.
 */
public interface UserService {

    void addUser(User user);

    List<User> findAll();

    void deleteUser(Long id);

    User queryById(Long id);

    void updateUser(User user);

    User checkUserNameAndPassword(User user);
}
