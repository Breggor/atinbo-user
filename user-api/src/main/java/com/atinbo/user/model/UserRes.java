package com.atinbo.user.model;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class UserRes {
    private String nickname;
    private int age;
}
