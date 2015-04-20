package com.xinux.test.service;

import java.util.List;

import com.xinux.test.model.User;
import com.xinux.test.user.exception.InvalidPasswordException;
import com.xinux.test.user.exception.UserNotFoundException;

public interface UserService {

    /**
     * 根据用户id查找用户
     * 
     * @param id
     * @return User
     */
    public User getUserById(int id);

    /**
     * 根据用户名userName查找用户
     * 
     * @param userName
     * @return
     */
    public User getuserByUserName(String userName);

    /**
     * 查找所有用户
     * 
     * @return List<User>
     */
    public List<User> getAllUsers();

    /**
     * 创建一个新用户
     * 
     * @param user
     * @return
     */
    public boolean createUser(User user);

    /**
     * 根据用户id删除一个用户
     * 
     * @param id
     * @return
     */
    public boolean deleteUserById(int id);

    /**
     * 更新一个用户的信息
     * 
     * @param user
     * @return
     */
    public boolean updateUserInfo(User user);

    /**
     * 用户登陆验证
     * 
     * @param userName
     * @param password
     * @return
     */
    public User loginUser(String userName, String password) throws UserNotFoundException,
                                                           InvalidPasswordException;

}
