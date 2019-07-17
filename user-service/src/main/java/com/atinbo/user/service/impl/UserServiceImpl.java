package com.atinbo.user.service.impl;

import com.atinbo.core.base.PageInfo;
import com.atinbo.core.service.model.Outcome;
import com.atinbo.core.service.model.PageOutcome;
import com.atinbo.user.model.UserBO;
import com.atinbo.user.model.UserParam;
import com.atinbo.user.model.UserQueryParam;
import com.atinbo.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
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
public class UserServiceImpl implements UserService {

    @Override
    public Outcome<UserBO> register(@RequestBody UserParam req) {
        log.info("register 入参===={}", req.toString());
        return Outcome.ofSuccess(new UserBO().setAge(30).setNickname("breggor"));
    }

    @Override
    public PageOutcome<UserBO> findUsers(UserQueryParam param) {
        List<UserBO> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            list.add(new UserBO().setAge(i).setNickname("breggor" + i));
        }
        return PageOutcome.ofSuccess(PageInfo.of(1, 10, 10, 100), list);
    }
}
