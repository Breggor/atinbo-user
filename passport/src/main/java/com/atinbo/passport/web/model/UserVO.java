package com.atinbo.passport.web.model;


import com.atinbo.core.http.model.BaseVO;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class UserVO implements BaseVO {
    private Long userId;
    private String nickname;
}
