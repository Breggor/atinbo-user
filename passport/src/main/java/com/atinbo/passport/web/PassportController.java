package com.atinbo.passport.web;


import com.atinbo.user.model.UserReq;
import com.atinbo.user.model.UserRes;
import com.atinbo.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 登录接口
 *
 * @author breggor
 */
@RestController
@RequestMapping
public class PassportController {
    @Autowired
    UserService userService;

    @PostMapping("/register")
    public UserRes register(@RequestBody UserReq req) {
        return userService.register(req);
    }
}
