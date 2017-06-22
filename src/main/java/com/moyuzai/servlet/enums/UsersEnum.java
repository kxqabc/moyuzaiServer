package com.moyuzai.servlet.enums;

/**
 * Created by kong on 17-6-22.
 */
public enum UsersEnum {
    GET_SUCCESS(true,1,"查找成功！"),
    MODIFY_SUCCESS(true,2,"密码更改成功!"),
    NOT_FOUND(false,0,"找不到这个用户！"),
    PASSWORD_ERROR(false,-1,"输入参数不合法！"),
    MODIFY_ERROR(false,-2,"密码更改失败!");
    private boolean state;
    private int stateNum;
    private String stateInfo;

    UsersEnum(boolean state, int stateNum, String stateInfo) {
        this.state = state;
        this.stateNum = stateNum;
        this.stateInfo = stateInfo;
    }

    public boolean isState() {
        return state;
    }

    public int getStateNum() {
        return stateNum;
    }

    public String getStateInfo() {
        return stateInfo;
    }
}
