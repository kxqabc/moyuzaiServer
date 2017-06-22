package com.moyuzai.servlet.dto;

import com.moyuzai.servlet.enums.LoginStateEnum;

/**
 * Created by xiang on 2017/6/21.
 */
public class LoginResponse extends BaseResponse {

    public LoginResponse() {
    }

    /**成功返回的信息*/
    public LoginResponse(boolean stateIn, Object dataIn) {
        state = stateIn;
        data = dataIn;
    }

    /**失败返回的信息*/
    public LoginResponse(boolean stateIn, LoginStateEnum loginStateEnum) {
        state = stateIn;
        stateInfo = loginStateEnum.getStateInfo();
    }
}
