package com.atinbo.passport.web;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(description = "用户查询表单")
public class UserQueryForm {

    @ApiModelProperty(value = "用户昵称",example = "张")
    private String nickname;
}
