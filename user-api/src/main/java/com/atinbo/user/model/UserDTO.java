package com.atinbo.user.model;


import com.atinbo.model.BaseBO;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author breggor
 */
@Data
@Accessors(chain = true)
public class UserDTO implements Serializable {
    private Long userId;
    private String nickname;
    private Integer age;
    private String direction;
    private String property;
}
