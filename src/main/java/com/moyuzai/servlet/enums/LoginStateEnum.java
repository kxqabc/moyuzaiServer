package com.moyuzai.servlet.enums;

/**
 * Created by xiang on 2017/6/21.
 */
public enum  LoginStateEnum {

    SUCCESS(1,"登录成功！"),NOT_FOUND(0,"找不到这个用户！"),PASSWORD_ERROR(-1,"账号或密码不正确！");
    private int stateNum;
    private String stateInfo;

    LoginStateEnum(int stateNum, String stateInfo) {
        this.stateNum = stateNum;
        this.stateInfo = stateInfo;
    }

    public int getStateNum() {
        return stateNum;
    }

    public String getStateInfo() {
        return stateInfo;
    }


}
