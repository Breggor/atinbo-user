package com.atinbo.passport.web.model;


import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 用户注册参数
 */
@Data
@Accessors(chain = true)
public class UserRegisterForm {
    private String nickname;
}
