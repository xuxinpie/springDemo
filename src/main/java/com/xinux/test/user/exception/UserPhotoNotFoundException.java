/*
 * Copyright (c) 2011
 * UNPUBLISHED PROPRIETARY SOURCE CODE.
 */

package com.xinux.test.user.exception;

/**
 * User photo was not found.
 *
 * @author Xinux
 */
public class UserPhotoNotFoundException extends Exception {
    public UserPhotoNotFoundException(String msg) {
        super(msg);
    }
}
