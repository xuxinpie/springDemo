/*
 * Copyright (c) 2011
 * UNPUBLISHED PROPRIETARY SOURCE CODE.
 */

package com.xinux.test.serviceImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xinux.test.dao.UserPhotoDao;
import com.xinux.test.model.UserPhoto;
import com.xinux.test.service.UserPhotoService;
import com.xinux.test.user.exception.UserPhotoNotFoundException;

/**
 * {@link UserPhoto} management service.
 *
 * @author Xinux
 */
@Service("userPhotoService")
public class UserPhotoServiceImpl implements UserPhotoService {
    private static final Logger logger = LoggerFactory.getLogger(UserPhotoServiceImpl.class);

    @Autowired
    private UserPhotoDao        userPhotoDao;

    @Override
    public UserPhoto createOrUpdateUserPhoto(UserPhoto userPhoto) {
        UserPhoto photo = userPhotoDao.findByUserId(userPhoto.getUserId());
        int key = 0;
        if (photo == null) {
            userPhotoDao.insert(userPhoto);
            key = userPhoto.getId();
            logger.info("Created user photo for user with id = " + userPhoto.getUserId());
        } else {
            userPhotoDao.update(userPhoto);
            logger.info("Updated user photo with id = " + userPhoto.getId());
        }
        UserPhoto up = userPhotoDao.findById(key);
        return up;
    }

    @Override
    public UserPhoto findPhotoByUserId(int userId) throws UserPhotoNotFoundException {
        UserPhoto userPhoto = userPhotoDao.findByUserId(userId);
        if (userPhoto == null) {
            throw new UserPhotoNotFoundException("User photo for user with id = [" + userId
                                                 + "] was not found.");
        }

        logger.info("Found user photo for user with id = [" + userId + "]");
        return userPhoto;
    }
}
