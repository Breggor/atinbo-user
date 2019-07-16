package com.atinbo.passport.web.model;


import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class UserVO {
    private Long userId;
    private String nickname;
}
