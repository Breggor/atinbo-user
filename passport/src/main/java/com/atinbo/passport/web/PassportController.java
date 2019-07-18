package com.atinbo.passport.web;


import com.atinbo.core.exception.HttpAPIException;
import com.atinbo.core.http.model.PageResult;
import com.atinbo.core.http.status.impl.Http500Error;
import com.atinbo.core.service.model.Outcome;
import com.atinbo.core.service.model.PageOutcome;
import com.atinbo.passport.web.mapper.UserMapper;
import com.atinbo.passport.web.model.UserRegisterForm;
import com.atinbo.passport.web.model.UserVO;
import com.atinbo.user.model.UserBO;
import com.atinbo.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * 登录接口
 *
 * @author breggor
 */
@RestController
@RequestMapping("/passport")
public class PassportController {
    @Autowired
    UserService userService;

    @PostMapping("/register")
    public UserVO register(@RequestBody @Validated UserRegisterForm form) throws HttpAPIException {

        Outcome<UserBO> outcome = userService.register(UserMapper.INSTANCE.toUserParam(form));
        if (outcome.isSuccess()) {
            return UserMapper.INSTANCE.toUserVO(outcome.getData());
        } else {
            throw new HttpAPIException(Http500Error.SYSTEM_ERROR);
        }
    }


    @GetMapping("/users")
    public PageResult<UserVO> users(@Validated UserQueryForm form) throws HttpAPIException {

        PageOutcome<UserBO> outcome = userService.findUsers(UserMapper.INSTANCE.toUserQueryParam(form));
        if (outcome.isSuccess()) {
            UserMapper.INSTANCE.toUserVOs(outcome.getData());
            return PageResult.of(outcome.getPage(), outcome.getData());
        } else {
            throw new HttpAPIException(Http500Error.SYSTEM_ERROR);
        }
    }
}
