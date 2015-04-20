package com.xinux.test.user.exception;

/**
 * The password entered during an sign-in attempt was invalid.
 * @author Xinux
 */
@SuppressWarnings("serial")
public final class InvalidPasswordException extends UserException {
    public InvalidPasswordException(String msg) {
        super(msg);
    }

    public InvalidPasswordException() {
        super("invalid password");
    }
}
