package com.atinbo.user.model;


import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@Accessors(chain = true)
public class UserParam implements Serializable {
    private Long id;
    private String nickname;
    private Integer age;
}
