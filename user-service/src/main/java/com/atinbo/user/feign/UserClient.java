package com.atinbo.user.feign;


import com.atinbo.core.query.DynamicSpecifications;
import com.atinbo.dislock.annotation.DisLock;
import com.atinbo.dislock.annotation.LockKey;
import com.atinbo.dislock.constant.DisLockType;
import com.atinbo.log.annotation.SysLog;
import com.atinbo.model.Outcome;
import com.atinbo.model.PageOutcome;
import com.atinbo.model.Pagination;
import com.atinbo.user.entity.User;
import com.atinbo.user.mapper.UserMapper;
import com.atinbo.user.model.UserDTO;
import com.atinbo.user.model.UserParam;
import com.atinbo.user.model.UserQueryParam;
import com.atinbo.user.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;


/**
 * 用户服务实现
 *
 * @author 陈路嘉
 */
@Slf4j
@RestController
@RequestMapping("/users")
public class UserClient implements IUserClient {
    @Autowired
    private UserRepository userRepository;

    /**
     * 增加用户信息
     *
     * @param param
     * @return
     */
    @Override
    @SysLog(value = "用户注册")
    @DisLock(lockType = DisLockType.MULTI)
    @LockKey({"UserParam.userId", "UserParam.username"})
    public Outcome<UserDTO> register(@RequestBody UserParam param) {
        User user = UserMapper.INSTANCE.toUser(param);
        user.setCreateAt(new Date());
        userRepository.save(user);
        UserDTO userBo = UserMapper.INSTANCE.toUserBO(user);
        return Outcome.ofSuccess(userBo);
    }

    /**
     * 通过多条件查询
     *
     * @param param
     * @return
     */
    @Override
    @SysLog(value = "用户分页条件查询")
    public PageOutcome<UserDTO> findAllByPage(UserQueryParam param) {
        String direction = param.getDirection();
        if (StringUtils.isBlank(direction)) {
            direction = "ASC";
        }
        Sort.Direction direction1 = Sort.Direction.fromString(direction);
        Sort sort = new Sort(direction1, param.getProperty());
        PageRequest pageRequest = PageRequest.of(param.getPage(), param.getSize(), sort);
        Page<User> page = userRepository.findAll(DynamicSpecifications.toSpecification(param), pageRequest);
        List<UserDTO> userBOs = UserMapper.INSTANCE.toUserBOs(page.getContent());
        return PageOutcome.ofSuccess(Pagination.of(page.getNumber(), page.getSize(), page.getTotalPages(), page.getTotalElements()), userBOs);
    }

    /**
     * 根据id查找用户信息
     *
     * @return
     */
    @Override
    @SysLog(value = "用户主键查询")
    public Outcome<UserDTO> findUsersById(Long userId) {
        User one = userRepository.getOne(userId);
        UserDTO userBo = UserMapper.INSTANCE.toUserBO(one);
        return Outcome.ofSuccess(userBo);
    }

    /**
     * 修改用户信息
     *
     * @param
     * @return
     */
    @Override
    @SysLog(value = "用户信息编辑")
    public Outcome<UserDTO> editUsersById(Long userId, UserParam param) {
        User user = UserMapper.INSTANCE.toUpdateUser(param, userRepository.getOne(userId));
        userRepository.saveAndFlush(user);
        UserDTO userBo = UserMapper.INSTANCE.toUserBO(user);
        return Outcome.ofSuccess(userBo);
    }

    /**
     * 删除用户信息
     *
     * @return
     */
    @Override
    @SysLog(value = "用户删除")
    public boolean deleteUserById(Long userId) {
        userRepository.deleteById(userId);
        return true;
    }

}
