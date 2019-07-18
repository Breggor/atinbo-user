package com.atinbo.user.model;


import com.atinbo.core.service.model.PageParam;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class UserQueryParam extends PageParam {
    private Long id;
    private String nickname;
}
