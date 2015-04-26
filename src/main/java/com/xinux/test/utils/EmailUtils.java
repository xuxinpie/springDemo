/*
 * Copyright (c) 2011
 * UNPUBLISHED PROPRIETARY SOURCE CODE.
 */

package com.xinux.test.utils;

import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;

/**
 * Email parsing/validation utilities.
 *
 * @author Xinux
 */
public final class EmailUtils {
    /**
     * Returns true if the String is a valid email address.
     */
    public static boolean isEmail(String string) {
        return !StringUtils.isEmpty(string) && emailPattern.matcher(string).matches();
    }

    private static final Pattern emailPattern = Pattern
                                                  .compile("[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}");

    private EmailUtils() {
    }
}
