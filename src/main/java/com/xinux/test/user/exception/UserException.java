package com.xinux.test.user.exception;

/**
 * Base class of the UserException hierarchy.
 * Marked abstract, as its designed to be subclasses.
 * A checked Exception, as AccountExceptions are recoverable business exceptions.
 *
 * @author Xinux 
 */
@SuppressWarnings("serial")
public abstract class UserException extends Exception {

    public UserException(String message) {
        super(message);
    }

    public UserException(String message, Throwable cause) {
        super(message, cause);
    }

}
