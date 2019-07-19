package com.atinbo.passport.web.model;


import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * 用户注册参数
 * @author 陈路嘉
 */
@Data
@Accessors(chain = true)
public class UserRegisterForm {

    @NotBlank(message = "昵称不为空")
    private String nickname;
    @NotNull(message = "年龄不能为空")
    private Integer age;
}
