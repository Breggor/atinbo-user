package com.atinbo.passport.web;


import com.atinbo.core.exception.HttpAPIException;
import com.atinbo.core.http.model.PageResult;
import com.atinbo.core.http.status.impl.Http500Error;
import com.atinbo.core.service.model.Outcome;
import com.atinbo.core.service.model.PageOutcome;
import com.atinbo.passport.web.mapper.UserMapper;
import com.atinbo.passport.web.model.UserForm;
import com.atinbo.passport.web.model.UserQueryForm;
import com.atinbo.passport.web.model.UserRegisterForm;
import com.atinbo.passport.web.model.UserVO;
import com.atinbo.user.model.UserBO;
import com.atinbo.user.service.UseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * 登录接口
 *
 * @author 陈路嘉
 */
@RestController
@RequestMapping("/passport")
@EnableAutoConfiguration
public class PassportController {
    @Autowired
    private UseService useService;

    /**
     * 注册用户
     * @param form
     * @return
     * @throws HttpAPIException
     */
    @PostMapping("/register")
    public UserVO register(@RequestBody @Validated UserRegisterForm form) throws HttpAPIException {

        Outcome<UserBO> outcome = useService.register(UserMapper.INSTANCE.toUserParam(form));
        if (outcome.isSuccess()) {
            return UserMapper.INSTANCE.toUserVO(outcome.getData());
        } else {
            throw new HttpAPIException(Http500Error.SYSTEM_ERROR);
        }
    }


    /**
     * 根据条件进行分页查询
     * @param form
     * @return
     * @throws HttpAPIException
     */
    @GetMapping
    public PageResult<UserVO> findUserByPage(@Validated UserQueryForm form) throws HttpAPIException {

        PageOutcome<UserBO> outcome = useService.findAllByPage(UserMapper.INSTANCE.toUserQueryParam(form));
        if (outcome.isSuccess()) {
            return PageResult.of(outcome.getPage(), UserMapper.INSTANCE.toUserVOs(outcome.getData()));
        } else {
            throw new HttpAPIException(Http500Error.SYSTEM_ERROR);
        }
    }

    /**
     * 根据用户ID进行查询
     * @return
     * @throws HttpAPIException
     */
    @GetMapping("/{userId}")
    public UserVO findUsersById(@PathVariable(value = "userId") Long userId) throws HttpAPIException {

        UserBO user = useService.findUsersById(userId);
        if (user!=null) {
            return UserMapper.INSTANCE.toUserVO(user);
        } else {
            throw new HttpAPIException(Http500Error.SYSTEM_ERROR);
        }
    }

    /**
     * 修改用户信息根据ID删除用户信息
     * @param form
     * @return
     * @throws HttpAPIException
     */
    @PutMapping("/{userId}")
    public UserVO editUser(@RequestBody @Validated UserForm form, @PathVariable("userId") Long userId) throws HttpAPIException {

        Outcome<UserBO> outcome = useService.editUsersById(userId,UserMapper.INSTANCE.toUpdateUserParam(form));
        if (outcome.isSuccess()) {
            return UserMapper.INSTANCE.toUserVO(outcome.getData());
        } else {
            throw new HttpAPIException(Http500Error.SYSTEM_ERROR);
        }
    }

    /**
     * 删除用户信息
     * @return
     * @throws HttpAPIException
     */
    @DeleteMapping("/{userId}")
    public Boolean deleteUser(@PathVariable(value = "userId") Long userId) throws HttpAPIException {

        boolean b = useService.deleteUserById(userId);
        if (b) {
            return true;
        } else {
            throw new HttpAPIException(Http500Error.SYSTEM_ERROR);
        }
    }

}
