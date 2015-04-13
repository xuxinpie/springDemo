package com.xinux.test.dao;

import java.util.List;

import com.xinux.test.model.User;

public interface UserDao {

    /**
     * 插入一条用户数据
     * 
     * @param user
     */
    public void insertUser(User user);

    /**
     * 根据用户Id查找对应用户，一个用户唯一对应一个UserId
     * 
     * @param id
     * @return
     */
    public User findUserById(int id);

    /**
     * 根据用户名查找用户
     * 
     * @param userName
     * @return
     */
    public User findUserByName(String userName);

    /**
     * 查找全部用户
     * 
     * @return
     */
    public List<User> findAllUsers();

    /**
     * 更新用户
     * 
     * @param user
     */
    public void updateUserInfo(User user);

    /**
     * 根据用户Id删除一个用户
     * 
     * @param id
     * @return 
     */
    public void deleteUserById(int id);

}
