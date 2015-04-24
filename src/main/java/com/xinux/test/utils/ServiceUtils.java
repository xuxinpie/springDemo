/*
 * Copyright (c) 2011
 * UNPUBLISHED PROPRIETARY SOURCE CODE.
 */

package com.xinux.test.utils;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

/**
 * Contains some common methods which are used in service web controllers.
 *
 * @author Xinux
 */
public class ServiceUtils {
    // get map of errors from BindingResult object
    public static String getErrorsList(BindingResult bindingResult) {
        StringBuilder builder = new StringBuilder();
        for (FieldError error : bindingResult.getFieldErrors()) {
            builder.append(" [").append(error.getField()).append("] ");
            builder.append(error.getDefaultMessage());
        }
        return builder.toString();
    }
}
