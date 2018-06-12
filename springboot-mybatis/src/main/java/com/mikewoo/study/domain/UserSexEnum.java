package com.mikewoo.study.domain;

/**
 * 性别枚举
 *
 * @auther Phantom Gui
 * @date 2018/6/12 14:19
 */
public enum UserSexEnum {

    MAN(1, "男"), WOMAN(2, "女");

    private int code;

    private String desc;

    UserSexEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
