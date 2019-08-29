package com.atinbo.user.model;


import com.atinbo.model.Operator;
import com.atinbo.model.PageParam;
import com.atinbo.model.Query;
import com.atinbo.model.QueryParam;
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
