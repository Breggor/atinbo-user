package com.atinbo.user.service;

import com.atinbo.user.model.UserReq;
import com.atinbo.user.model.UserRes;
import com.atinbo.user.fallback.UserServiceFallback;
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
     * @param req
     * @return
     */
    @PostMapping("/register")
    UserRes register(@RequestBody UserReq req);
}
