package com.xinux.test.user.exception;

/**
 * User account was not found.
 *
 * @author Xinux
 */

@SuppressWarnings("serial")
public class UserNotFoundException extends UserException {
    public UserNotFoundException(String msg) {
        super(msg);
    }
}
