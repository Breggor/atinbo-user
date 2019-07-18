package com.atinbo.passport.web.mapper;


import com.atinbo.passport.web.UserQueryForm;
import com.atinbo.passport.web.model.UserRegisterForm;
import com.atinbo.passport.web.model.UserVO;
import com.atinbo.user.model.UserBO;
import com.atinbo.user.model.UserParam;
import com.atinbo.user.model.UserQueryParam;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserParam toUserParam(UserRegisterForm form);

    UserVO toUserVO(UserBO bo);

    UserQueryParam toUserQueryParam(UserQueryForm form);

    List<UserVO> toUserVOs(List<UserBO> data);
}
