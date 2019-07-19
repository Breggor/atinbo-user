package com.atinbo.passport.web.model;

import com.atinbo.core.service.model.PageParam;
import lombok.Data;

/**
 * 用户查询参数
 * @author 陈路嘉
 */
@Data
public class UserQueryForm extends PageParam {
    private Long userId;
    private String nickname;
    private Integer age;
}
