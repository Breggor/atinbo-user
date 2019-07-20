package com.atinbo.user.model;


import com.atinbo.core.service.model.PageParam;
import com.atinbo.user.search.Operator;
import com.atinbo.user.search.Query;
import com.atinbo.user.search.QueryParam;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 用户查询参数
 * @author 陈路嘉
 */
@Data
@Accessors(chain = true)
public class UserQueryParam extends PageParam implements QueryParam {
    private Long userId;
    @Query(operator = Operator.LIKE,field = "nickName")
    private String nickname;
    private Integer age;

    private String direction;
    private String property;
}
