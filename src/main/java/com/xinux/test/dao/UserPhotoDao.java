package com.xinux.test.dao;

import org.apache.ibatis.annotations.Param;

import com.xinux.test.model.UserPhoto;

/**
 * Genereal DAO for {@link UserDao} domain.
 *
 * @author Xinux
 */
public interface UserPhotoDao {
    /**
     * Creates <code>UserPhoto</code>.
     *
     * @param userPhoto user photo to save.
     */
    public void insert(UserPhoto userPhoto);

    /**
     * Updates <code>UserPhoto</code>.
     *
     * @param userPhoto user photo to update.
     */
    public void update(UserPhoto userPhoto);

    /**
     * Finds user photo by user id.
     *
     * @param userId user unique identifier.
     * @return <code>UserPhoto<code>
     */
    public UserPhoto findByUserId(@Param("userId") int userId);

    /**
     * Retrieves the {@link UserPhoto user photo} with the specified unique identifier.
     *
     * @param id the unique identifier of the <code>UserPhoto</code> to be returned.
     * @return the <code>UserPhoto</code> with the specified unique identifier or
     *         <code>null</code> if there is no such item.
     */
    public UserPhoto findById(int id);

    /**
     * Removes (aka sets active=false) user photo by user id.
     * @param id unique id of user to remove.
     */
    public void removeByUserId(int id);
}
