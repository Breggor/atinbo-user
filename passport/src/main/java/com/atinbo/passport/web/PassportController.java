package com.atinbo.passport.web;


import com.atinbo.core.exception.HttpAPIException;
import com.atinbo.core.http.model.PageResult;
import com.atinbo.core.http.status.HttpStatusCode;
import com.atinbo.core.service.model.Outcome;
import com.atinbo.core.service.model.PageOutcome;
import com.atinbo.passport.web.mapper.UserMapper;
import com.atinbo.passport.web.model.UserForm;
import com.atinbo.passport.web.model.UserQueryForm;
import com.atinbo.passport.web.model.UserRegisterForm;
import com.atinbo.passport.web.model.UserVO;
import com.atinbo.user.model.UserBO;
import com.atinbo.user.service.UserService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * 登录接口
 *
 * @author 陈路嘉
 * @EnableAutoConfiguration可以帮助SpringBoot应用将所有符合条件的
 * @Configuration配置都加载到当前SpringBoot创建并使用的IoC容器。
 */
@Api(tags = "用户注册、查询")
@RestController
@RequestMapping("/passport")
public class PassportController {
    @Autowired
    private UserService userService;

    /**
     * 注册用户
     *
     * @param form
     * @return
     * @throws HttpAPIException
     */
    @ApiOperation(value = "用户注册")
    @ApiResponses(@ApiResponse(code = 500001, message = "系统错误"))
    @PostMapping("/register")
    public Outcome<UserBO> register(@RequestBody @Validated @ApiParam("用户注册基本信息") UserRegisterForm form) throws HttpAPIException {

        Outcome<UserBO> outcome = userService.register(UserMapper.INSTANCE.toUserParam(form));
        if (outcome.isSuccess()) {
            return UserMapper.INSTANCE.toUserVO(outcome.getData());
        } else {
            throw new HttpAPIException(HttpStatusCode.ERR_500);
        }
    }


    /**
     * 根据条件进行分页查询
     *
     * @param form
     * @return
     * @throws HttpAPIException
     */
    @ApiOperation(value = "分页查询")
    @ApiResponses(@ApiResponse(code = 500001, message = "系统错误"))
    @GetMapping
    public PageResult<UserVO> findUserByPage(@Validated @ApiParam("用户查询参数") UserQueryForm form) throws HttpAPIException {

        PageOutcome<UserBO> outcome = userService.findAllByPage(UserMapper.INSTANCE.toUserQueryParam(form));
        if (outcome.isSuccess()) {
            return PageResult.of(outcome.getPage(), UserMapper.INSTANCE.toUserVOs(outcome.getData()));
        } else {
            throw new HttpAPIException(HttpStatusCode.ERR_500);
        }
    }

    /**
     * 根据用户ID进行查询
     *
     * @return
     * @throws HttpAPIException
     */
    @ApiOperation(value = "根据ID查询用户")
    @ApiResponses(@ApiResponse(code = 500001, message = "系统错误"))
    @GetMapping("/{userId}")
    public Outcome<UserBO> findUsersById(@PathVariable(value = "userId") @ApiParam("userId") Long userId) throws HttpAPIException {

        Outcome<UserBO> user = userService.findUsersById(userId);
        if (user.isSuccess()) {
            return UserMapper.INSTANCE.toUserVO(user.getData());
        } else {
            throw new HttpAPIException(HttpStatusCode.ERR_500);
        }
    }

    /**
     * 修改用户信息根据ID删除用户信息
     *
     * @param form
     * @return
     * @throws HttpAPIException
     */
    @ApiOperation(value = "修改用户")
    @ApiResponses(@ApiResponse(code = 500001, message = "系统错误"))
    @PutMapping("/{userId}")
    public Outcome<UserBO> editUser(@RequestBody @Validated @ApiParam("用户参数") UserForm form, @ApiParam("用户ID") @PathVariable("userId") Long userId) throws HttpAPIException {

        Outcome<UserBO> outcome = userService.editUsersById(userId, UserMapper.INSTANCE.toUpdateUserParam(form));
        if (outcome.isSuccess()) {
            return UserMapper.INSTANCE.toUserVO(outcome.getData());
        } else {
            throw new HttpAPIException(HttpStatusCode.ERR_500);
        }
    }

    /**
     * 删除用户信息
     *
     * @return
     * @throws HttpAPIException
     */
    @ApiOperation("用户删除")
    @ApiResponses(@ApiResponse(code = 500001, message = "系统错误"))
    @DeleteMapping("/{userId}")
    public Boolean deleteUser(@PathVariable(value = "userId") @ApiParam("用户ID") Long userId) throws HttpAPIException {

        boolean result = userService.deleteUserById(userId);
        if (result) {
            return true;
        } else {
            throw new HttpAPIException(HttpStatusCode.ERR_500);
        }
    }

}
