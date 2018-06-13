package com.mikewoo.study.domain;

/**
 * 用户类型枚举
 *
 * @auther Phantom Gui
 * @date 2018/6/13 13:30
 */
public enum UserType {
    SYSTEM_USER(1, "系统用户"), WX_USER(2, "微信用户"), APP_USER(3, "APP用户");

    private Integer type;

    private String desc;

    UserType(Integer type, String desc) {
        this.type = type;
        this.desc = desc;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
