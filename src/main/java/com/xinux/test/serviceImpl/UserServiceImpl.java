package com.xinux.test.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xinux.test.dao.UserDao;
import com.xinux.test.model.User;
import com.xinux.test.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User getUserById(int id) {
        User user = userDao.findUserById(id);
        return user;
    }

    @Override
    public User getuserByUserName(String userName) {
        User user = userDao.findUserByName(userName);
        return user;
    }

    @Override
    public List<User> getAllUsers() {
        List<User> users = userDao.findAllUsers();
        return users;
    }

    @Override
    public boolean createUser(User user) {
        int effectedRows = userDao.insertUser(user);
        int key = user.getId();
        System.out.println("effect Rows: " + effectedRows);
        System.out.println("Insert UserId: " + key);
        return key > 0 ? true : false;
    }

    @Override
    public boolean deleteUserById(int id) {
        int effectedRows = userDao.deleteUserById(id);
        if (effectedRows > 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean updateUserInfo(User user) {
        int effectedRows = userDao.updateUserInfo(user);
        if (effectedRows > 0) {
            return true;
        } else {
            return false;
        }
    }
}
