package com.meitu.search.exception;

/**
 * @ClassName OptExcetion
 * @Description TODO
 * @Author wangrq
 * @Date 2020/9/1 21:03
 */
public class OptException extends RuntimeException {

    public OptException() {
    }

    public OptException(String message) {
        super(message);
    }

    public OptException(String message, Throwable cause) {
        super(message, cause);
    }

    public OptException(Throwable cause) {
        super(cause);
    }

    public OptException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
