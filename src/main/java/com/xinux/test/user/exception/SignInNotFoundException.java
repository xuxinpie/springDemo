package com.xinux.test.user.exception;

/**
 * The provided signin name could not be mapped.
 *
 * @author Xinux
 */
@SuppressWarnings("serial")
public final class SignInNotFoundException extends UserException {

    private final String username;

    public SignInNotFoundException(String username) {
        super("username not found");
        this.username = username;
    }

    public String getUsername() {
        return username;
    }
}
