package com.atinbo.user.model;

import com.atinbo.core.service.model.BaseBO;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author 陈路嘉
 */
@Data
@Accessors(chain = true)
public class UserBO implements BaseBO {
    private Long userId;
    private String nickname;
    private Integer age;
    private String direction;
    private String property;
}
