package com.atinbo.passport.web.mapper;


import com.atinbo.passport.web.model.UserForm;
import com.atinbo.passport.web.model.UserQueryForm;
import com.atinbo.passport.web.model.UserRegisterForm;
import com.atinbo.passport.web.model.UserVO;
import com.atinbo.user.model.UserBO;
import com.atinbo.user.model.UserParam;
import com.atinbo.user.model.UserQueryParam;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * 用户进行参数转换。
 *
 * @author 陈路嘉
 */
@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    /**
     * 转换注册参数为用户参数
     *
     * @param form
     * @return
     */
    UserParam toUserParam(UserRegisterForm form);

    /**
     * 转换修改参数为用户参数
     *
     * @param form
     * @return
     */
    UserParam toUpdateUserParam(UserForm form);

    /**
     * 转换进参转换为出参
     *
     * @param bo
     * @return
     */
    UserVO toUserVO(UserBO bo);

    /**
     * 将用户查询参数转换为用户参数
     *
     * @param form
     * @return
     */
    UserQueryParam toUserQueryParam(UserQueryForm form);

    /**
     * 将用户进参列表转换为用户出参列表
     *
     * @param data
     * @return
     */
    List<UserVO> toUserVOs(List<UserBO> data);
}
