package com.moyuzai.servlet.dto;

import com.moyuzai.servlet.enums.UsersEnum;

/**
 * Created by kong on 17-6-22.
 */
public class UsersResponse extends BaseResponse {

    /**有对象返回的信息*/
    public UsersResponse(UsersEnum enums , Object data) {
        this.state = enums.isState();
        this.data = data;
    }

    /**无对象返回的信息*/
    public UsersResponse(UsersEnum enums) {
        state = enums.isState();
        stateInfo = enums.getStateInfo();
    }
}
