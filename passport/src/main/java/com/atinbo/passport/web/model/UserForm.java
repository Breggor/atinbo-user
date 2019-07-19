package com.atinbo.passport.web.model;

import lombok.Data;

/**
 * 用户普通入参参数
 * @author 陈路嘉
 */
@Data
public class UserForm {

    private Long userId;
    private String nickname;
    private Integer age;
}
