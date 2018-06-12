package com.mikewoo.study.ums.vo;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

/**
 * 前端传的用户参数
 *
 * @auther Phantom Gui
 * @date 2018/6/11 20:05
 */
public class UserParamVo {

    private long id;

    @NotEmpty(message="姓名不能为空")
    private String userName;

    @NotEmpty(message="密码不能为空")
    @Length(min=6,message="密码长度不能小于 6 位")
    private String passWord;

    @Max(value = 100, message = "年龄不能大于 100 岁")
    @Min(value= 18 ,message= "必须年满 18 岁！" )
    private int age;

    public UserParamVo() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
