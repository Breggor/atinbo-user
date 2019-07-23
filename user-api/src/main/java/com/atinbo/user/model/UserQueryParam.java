package com.atinbo.user.model;


import com.atinbo.core.query.Operator;
import com.atinbo.core.query.Query;
import com.atinbo.core.query.QueryParam;
import com.atinbo.core.service.model.PageParam;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 用户查询参数
 * @author 陈路嘉
 */
@Data
@Accessors(chain = true)
public class UserQueryParam extends PageParam implements QueryParam {
    @Query(field = "id")
    private Long userId;
    @Query(operator = Operator.LIKE,field = "nickName")
    private String nickname;
    private Integer age;

    @Query(ignore = true)
    private String direction;
    @Query(ignore = true)
    private String property;
}
