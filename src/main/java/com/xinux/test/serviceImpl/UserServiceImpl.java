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
    public void createUser(User user) {
        userDao.insertUser(user);
    }

    @Override
    public void deleteUserById(int id) {
        /*int index = userDao.deleteUserById(id);
        if (index > 0) {
            return true;
        }
        return false;*/
        userDao.deleteUserById(id);
    }

    @Override
    public boolean updateUserInfo(User user, int id) {
        return false;
    }

}
