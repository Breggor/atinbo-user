package com.atinbo.user.service;

import com.atinbo.core.service.model.Outcome;
import com.atinbo.core.service.model.PageOutcome;
import com.atinbo.user.fallback.UserServiceFallback;
import com.atinbo.user.model.UserBO;
import com.atinbo.user.model.UserParam;
import com.atinbo.user.model.UserQueryParam;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * 用户接口
 *
 * @author breggor
 */
@FeignClient(name = "user-service", path = "/users", fallback = UserServiceFallback.class)
public interface UserService {

    /**
     * 会员注册
     *
     * @param param
     * @return
     */
    @PostMapping("/register")
    Outcome<UserBO> register(@RequestBody UserParam param);


    /**
     * 会员列表
     *
     * @param param
     * @return
     */
    @GetMapping
    PageOutcome<UserBO> findUsers(@RequestBody UserQueryParam param);
}
