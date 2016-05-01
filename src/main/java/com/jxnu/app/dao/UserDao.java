package com.jxnu.app.dao;

import com.jxnu.app.model.User;

import java.util.List;

/**
 * Created by puchunwei on 16/5/1.
 */
public interface UserDao {

    void addUser(User user);

    void deleteUser(Long id);

    void updateUser(User user);

    User queryById(Long id);

    List<User> findAll();

}
