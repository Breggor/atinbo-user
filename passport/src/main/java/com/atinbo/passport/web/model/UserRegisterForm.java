package com.atinbo.passport.web.model;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * 用户注册参数
 *
 * @author 陈路嘉
 */
@Data
@Accessors(chain = true)
@ApiModel(description = "用户注册信息")
public class UserRegisterForm {

    @NotBlank(message = "昵称不为空")
    @ApiModelProperty(value = "用户昵称", required = true, example = "张三")
    private String nickname;

    @NotNull(message = "年龄不能为空")
    @ApiModelProperty(value = "用户年龄（必须在18-60岁之间）", example = "20")
    private Integer age;
}
