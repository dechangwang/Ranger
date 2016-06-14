package cn.edu.tongji.ranger.utils;

import java.io.Serializable;

public class ReturnWrapper<T> implements Serializable {

    private ReturnStatusEnum status;
    private ReturnCodeEnum code;
    private String message;

    private T data;

//    private String sessionKey;

    public ReturnWrapper() {
        this.status = ReturnStatusEnum.SUCCEED;
        this.code = ReturnCodeEnum.No_Error;
    }

    public ReturnStatusEnum getStatus() {
        return status;
    }

    public void setStatus(ReturnStatusEnum status) {
        this.status = status;
    }

    public ReturnCodeEnum getCode() {
        return code;
    }

    public void setCode(ReturnCodeEnum code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

//    public String getSessionKey() {
//        return sessionKey;
//    }
//
//    public void setSessionKey(String sessionKey) {
//        this.sessionKey = sessionKey;
//    }
}
