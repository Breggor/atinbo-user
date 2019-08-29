package com.atinbo.user.mapper;

import com.atinbo.user.entity.User;
import com.atinbo.user.model.UserDTO;
import com.atinbo.user.model.UserParam;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * 用户转换参数接口
 *
 * @author 陈路嘉
 */
@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    /**
     * 将用户参数转化为用户
     *
     * @param param
     * @return
     */
    @Mappings({@Mapping(target = "nickName", source = "nickname"), @Mapping(target = "id", source = "userId")})
    User toUser(UserParam param);

    /**
     * 将用户转换为用户进参形式
     *
     * @param user
     * @return
     */
    @Mappings({@Mapping(target = "nickname", source = "nickName"), @Mapping(target = "userId", source = "id")})
    UserDTO toUserBO(User user);

    /**
     * 将用户列表转换为用户进参列表
     *
     * @param all
     * @return
     */
    List<UserDTO> toUserBOs(List<User> all);

    /**
     * 将用户修改参数转换为用户参数
     *
     * @param param
     * @param user
     * @return
     */
    @Mappings({@Mapping(target = "nickName", source = "nickname")})
    User toUpdateUser(UserParam param, @MappingTarget User user);

}
