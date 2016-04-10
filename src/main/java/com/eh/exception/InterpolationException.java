package com.eh.exception;

/**
 * Created by David on 2016/4/10.
 */
public class InterpolationException extends RuntimeException {
    private String errorMsg;

    public InterpolationException(String errorMsg) {
        super(errorMsg);
    }
}
