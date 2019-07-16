package com.atinbo.passport.web.model;


import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;

/**
 * 用户注册参数
 */
@Data
@Accessors(chain = true)
public class UserRegisterForm {

    @NotBlank(message = "昵称不为空")
    private String nickname;
}
