package com.atinbo.openapi.web.model;


import com.atinbo.core.http.model.BaseVO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 用户出参参数
 *
 * @author 陈路嘉
 */
@Data
@Accessors(chain = true)
@ApiModel(description = "用户基本资料")
public class UserVO implements BaseVO {

    @ApiModelProperty(value = "用户id", required = true, example = "1")
    private Long userId;

    @ApiModelProperty(value = "用户昵称", example = "孙大圣")
    private String nickname;

    @ApiModelProperty(value = "用户年龄",example = "18")
    private Integer age;
}
