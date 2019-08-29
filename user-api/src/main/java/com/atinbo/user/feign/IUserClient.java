package com.atinbo.user.feign;

import com.atinbo.model.Outcome;
import com.atinbo.model.PageOutcome;
import com.atinbo.user.fallback.UserClientFallback;
import com.atinbo.user.model.UserDTO;
import com.atinbo.user.model.UserParam;
import com.atinbo.user.model.UserQueryParam;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * 用户接口
 *
 * @author breggor
 */
@FeignClient(name = "user-service", path = "/users", fallback = UserClientFallback.class)
public interface IUserClient {
    /**
     * 用户注册
     *
     * @param param
     * @return
     */
    @PostMapping
    Outcome<UserDTO> register(@RequestBody UserParam param);

    /**
     * 用户根据分页查找
     *
     * @param param
     * @return
     */
    @GetMapping
    PageOutcome<UserDTO> findAllByPage(@RequestBody UserQueryParam param);

    /**
     * 用户根据id进行查找
     *
     * @param userId
     * @return
     */
    @GetMapping("/{userId}")
    Outcome<UserDTO> findUsersById(@PathVariable(value = "userId") Long userId);

    /**
     * 根据id修改用户信息
     *
     * @param userId
     * @param param
     * @return
     */
    @PutMapping("/{userId}")
    Outcome<UserDTO> editUsersById(@PathVariable(value = "userId") Long userId, @RequestBody UserParam param);

    /**
     * 根据用户id进行删除
     *
     * @param userId
     * @return
     */
    @DeleteMapping("/{userId}")
    boolean deleteUserById(@PathVariable(value = "userId") Long userId);
}
