package cn.edu.tongji.ranger.utils;

public enum ReturnCodeEnum {
    No_Error("No Error", 0),
    Unknown_Error("Unknown Error", 1),
    SESSION_NOT_EXIST("Session not exist", 2),
    CURRENT_PASSWORD_WRONG("Current password wrong", 3),
    BALANCE_NOT_ENOUGH("Balance not enough", 4);

    private String content;
    private Integer code;

    ReturnCodeEnum() {
    }

    ReturnCodeEnum(String content, Integer code) {
        this.setContent(content);
        this.setCode(code);
    }

    public static ReturnCodeEnum parse(int code) {
        for (ReturnCodeEnum theEnum : ReturnCodeEnum.values()) {
            if (theEnum.getCode() == code) {
                return theEnum;
            }
        }
        return No_Error;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return code.toString();
    }
}
