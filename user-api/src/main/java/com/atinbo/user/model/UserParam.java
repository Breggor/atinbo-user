package com.atinbo.user.model;


import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author 陈路嘉
 */
@Data
@Accessors(chain = true)
public class UserParam implements Serializable {
    private Long userId;
    private String nickname;
    private Integer age;
}
