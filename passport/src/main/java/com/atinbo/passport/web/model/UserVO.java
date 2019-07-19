package com.atinbo.passport.web.model;


import com.atinbo.core.http.model.BaseVO;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 用户出参参数
 * @author 陈路嘉
 */
@Data
@Accessors(chain = true)
public class UserVO implements BaseVO {
    private Long userId;
    private String nickname;
    private Integer age;
}
