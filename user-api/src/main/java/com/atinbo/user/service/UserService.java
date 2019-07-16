package com.atinbo.user.service;

import com.atinbo.core.service.model.Outcome;
import com.atinbo.user.fallback.UserServiceFallback;
import com.atinbo.user.model.UserBO;
import com.atinbo.user.model.UserParam;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * 用户接口
 *
 * @author breggor
 */
@FeignClient(name = "user-service", path = "/user", fallback = UserServiceFallback.class)
public interface UserService {

    /**
     * 会员注册
     *
     * @param param
     * @return
     */
    @PostMapping("/register")
    Outcome<UserBO> register(@RequestBody UserParam param);
}
