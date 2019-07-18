package com.atinbo.passport.web.model;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotBlank;

/**
 * 用户注册参数
 */
@Data
@Accessors(chain = true)
@ApiModel(description = "用户注册信息")
public class UserRegisterForm {

    @ApiModelProperty(value = "用户昵称", required = true, example = "张三")
    @NotBlank(message = "昵称不为空")
    private String nickname;

    @ApiModelProperty(value = "用户年龄（必须在18-60岁之间）", example = "20")
    @Range(min = 18, max = 60, message = "年龄必须在18-60岁之间")
    private Integer age;
}
