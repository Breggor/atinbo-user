package com.atinbo.user.service.impl;

import com.atinbo.user.model.UserReq;
import com.atinbo.user.model.UserRes;
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
    public UserRes register(@RequestBody UserReq req) {
        log.info(req.toString());
        return new UserRes().setNickname("breggor").setAge(35);
    }
}
