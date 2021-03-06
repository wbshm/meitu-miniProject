package com.meitu.search.entity;

/**
 * @ClassName ResultEntity
 * @Description TODO
 * @Author wangrq
 * @Date 2020/9/1 21:35
 */
public class ResultEntity<T> {
    private static final String SUCCESS = "success";
    private static final String FAILED = "failed";

    private int code;
    private String msg;
    private T data;

    public static <Type> ResultEntity<Type> successWithoutData() {
        return new ResultEntity<>(0, SUCCESS, null);
    }

    public static <Type> ResultEntity<Type> successWithData(Type data) {
        return new ResultEntity<>(0, SUCCESS, data);
    }

    public static <Type> ResultEntity<Type> successWithData(int code, Type data) {
        return new ResultEntity<>(code, SUCCESS, data);
    }

    public static <Type> ResultEntity<Type> failed(String message) {
        return new ResultEntity<>(-1, message, null);
    }

    public static <Type> ResultEntity<Type> failed(int code, String message) {
        return new ResultEntity<>(code, message, null);
    }

    public ResultEntity(int code, String message, T data) {
        this.setCode(code);
        this.setMsg(message);
        this.setData(data);
    }

    public ResultEntity() {
    }


    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
