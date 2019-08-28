package com.atinbo.openapi.web.model;

import lombok.Data;

/**
 * 用户查询参数
 *
 * @author 陈路嘉
 */
@Data
public class UserQueryForm {
    private Long userId;
    private String nickname;
    private Integer age;
    private String direction;
    private String property;
    private Integer page;
    private Integer size;

}
