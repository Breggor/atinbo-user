package com.atinbo.user.model;


import com.atinbo.core.service.model.PageParam;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 用户查询参数
 * @author 陈路嘉
 */
@Data
@Accessors(chain = true)
public class UserQueryParam extends PageParam {
    private Long userId;
    private String nickname;
    private Integer age;
}
