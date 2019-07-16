package com.atinbo.passport.web;


import com.atinbo.core.exception.APIException;
import com.atinbo.core.http.status.impl.Enum500Error;
import com.atinbo.core.service.model.Outcome;
import com.atinbo.passport.web.model.UserRegisterForm;
import com.atinbo.passport.web.model.UserVO;
import com.atinbo.user.model.UserBO;
import com.atinbo.user.model.UserParam;
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
    public UserVO register(@RequestBody UserRegisterForm form) throws APIException {
        Outcome<UserBO> outcome = userService.register(new UserParam());
        if (outcome.isSuccess()) {
            return new UserVO();
        } else {
            throw new APIException(Enum500Error.SYSTEM_ERROR);
        }
    }
}
