package com.atinbo.user.service.impl;

import com.atinbo.core.service.model.Outcome;
import com.atinbo.user.model.UserBO;
import com.atinbo.user.model.UserParam;
import com.atinbo.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * 用户服务实现
 *
 * @author breggor
 */
@Slf4j
@RestController
@RequestMapping("/user")
public class UserServiceImpl implements UserService {

    @Override
    public Outcome<UserBO> register(@RequestBody UserParam req) {
        log.info("register 入参===={}", req.toString());
        return Outcome.ofSuccess(new UserBO().setAge(30).setNickname("breggor"));
    }
}
