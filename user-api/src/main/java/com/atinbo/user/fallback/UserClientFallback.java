package com.atinbo.user.fallback;

import com.atinbo.model.Outcome;
import com.atinbo.model.PageOutcome;
import com.atinbo.user.model.UserDTO;
import com.atinbo.user.model.UserParam;
import com.atinbo.user.model.UserQueryParam;
import com.atinbo.user.feign.IUserClient;

public class UserClientFallback implements IUserClient {
   @Override
    public Outcome<UserDTO> register(UserParam req) {
        return Outcome.<UserDTO>ofFail("接口异常");
    }

    @Override
    public PageOutcome<UserDTO> findAllByPage(UserQueryParam param) {
        return PageOutcome.ofFail("接口异常");
    }

    @Override
    public Outcome<UserDTO> findUsersById(Long userId) {
        return Outcome.ofFail("接口异常");
    }

    @Override
    public Outcome<UserDTO> editUsersById(Long userId, UserParam param) {
        return Outcome.ofFail("接口异常");
    }

    @Override
    public boolean deleteUserById(Long userId) {
        return false;
    }


}
