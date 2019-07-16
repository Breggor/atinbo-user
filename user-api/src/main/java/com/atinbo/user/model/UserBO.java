package com.atinbo.user.model;

import com.atinbo.core.service.model.BaseBO;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class UserBO implements BaseBO {
    private String nickname;
    private int age;
}
