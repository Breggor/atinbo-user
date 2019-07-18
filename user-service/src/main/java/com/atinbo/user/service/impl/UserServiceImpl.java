package com.atinbo.user.service.impl;

import com.atinbo.core.base.PageInfo;
import com.atinbo.core.service.model.Outcome;
import com.atinbo.core.service.model.PageOutcome;
import com.atinbo.user.mapper.UserMapper;
import com.atinbo.user.model.UserBO;
import com.atinbo.user.model.UserParam;
import com.atinbo.user.model.UserQueryParam;
import com.atinbo.user.service.UseFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


/**
 * 用户服务实现
 *
 * @author breggor
 */
@Slf4j
@RestController
@RequestMapping("/users")
@EnableAutoConfiguration
public class UserServiceImpl implements UseFeignService {
    @Autowired
    private UserMapper userMapper;

    /**
     * 增加用户信息
     * @param req
     * @return
     */
    @Override
    public Outcome<UserBO> register(@RequestBody UserParam req) {
        log.info("register 入参===={}", req.toString());
        /*return Outcome.ofSuccess(new UserBO().setAge(30).setNickname("breggor"));*/
        UserBO userBO=new UserBO();
        userBO.setNickname(req.getNickname());
        userBO.setAge(req.getAge());
        UserBO save = userMapper.save(userBO);
        return Outcome.ofSuccess(save);
    }

    /**
     * 查找用户信息
     * @param param
     * @return
     */
    @Override
    public PageOutcome<UserBO> findUsers(UserQueryParam param) {
        List<UserBO> all = userMapper.findAll();
        return PageOutcome.ofSuccess(PageInfo.of(1, 10, 10, 100), all);
    }

    /**
     * 根据id查找用户信息
     * @param param
     * @return
     */
    @Override
    public PageOutcome<UserBO> findUsersById(UserQueryParam param) {
        List<UserBO> list = new ArrayList<>();
        UserBO one = userMapper.getOne(param.getId());
        list.add(one);
        return PageOutcome.ofSuccess(PageInfo.of(1, 10, 10, 100), list);
    }

    /**
     * 修改用户信息
     * @param param
     * @return
     */
    @Override
    public Outcome<UserBO> editUsersById(UserParam param) {
        UserBO one = userMapper.getOne(param.getId());
        one.setNickname(param.getNickname());
        one.setAge(param.getAge());
        UserBO userBO = userMapper.saveAndFlush(one);
        return Outcome.ofSuccess(userBO);
    }

    /**
     * 删除用户信息
     * @param id
     * @return
     */
    @Override
    public boolean deleteUsers(Long id) {
        userMapper.deleteById(id);
        return true;
    }


}
