/*
 * Copyright (c) 2011
 * UNPUBLISHED PROPRIETARY SOURCE CODE.
 */

package com.xinux.test.service;

import com.xinux.test.model.UserPhoto;
import com.xinux.test.user.exception.UserPhotoNotFoundException;

/**
 * Service interface for working with {@link UserPhoto}.
 *
 * @author Xinux
 */
public interface UserPhotoService {
    /**
     * Creates or updates existing user photo.
     *
     * @param userPhoto user photo to create/update.
     * @return <code>UserPhoto</code>
     */
    UserPhoto createOrUpdateUserPhoto(UserPhoto userPhoto);

    /**
     * Find user photo by user unique id.
     * @param userId id of user to get photo.
     * @return <code>UserPhoto</code> with the given id.
     * @throws UserPhotoNotFoundException if userPhoto was not found.
     */
    UserPhoto findPhotoByUserId(int userId) throws UserPhotoNotFoundException;
}
