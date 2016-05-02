package com.jxnu.app.service.impl;

import com.jxnu.app.dao.UserDao;
import com.jxnu.app.model.User;
import com.jxnu.app.service.UserService;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by puchunwei on 16/5/1.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    public void addUser(User user) {
        userDao.addUser(user);
    }

    public List<User> findAll() {
        return userDao.findAll();
    }

    public void deleteUser(Long id) {
        userDao.deleteUser(id);
    }

    public User queryById(Long id) {
        return userDao.queryById(id);
    }

    public void updateUser(User user) {
        userDao.updateUser(user);
    }

    public User checkUserNameAndPassword(User user) {
        List<User> userList = userDao.queryByNameAndPassword(user);
        if (CollectionUtils.isNotEmpty(userList)) {
            return userList.get(0);
        }
        return null;
    }

}
