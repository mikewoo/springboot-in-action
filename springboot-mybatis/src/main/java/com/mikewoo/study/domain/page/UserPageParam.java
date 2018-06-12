package com.mikewoo.study.domain.page;

/**
 * 用户分页查询条件
 *
 * @auther Phantom Gui
 * @date 2018/6/12 16:11
 */
public class UserPageParam extends PageParam {

    private String userName;

    private String userSex;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserSex() {
        return userSex;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex;
    }
}
