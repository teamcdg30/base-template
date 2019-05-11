package com.cdg.base.common.exception;

import lombok.Getter;

@Getter
public class BaseException extends RuntimeException {

    private static final long serialVersionUID = -823166844470942984L;

    private final int code;

    public BaseException(int code, String message, Exception ex) {
        super(message, ex);
        this.code = code;
    }

    public BaseException(int code, String message) {
        super(message);
        this.code = code;
    }

}