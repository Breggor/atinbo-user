package com.atinbo.user.fallback;

import com.atinbo.core.service.model.Outcome;
import com.atinbo.core.service.model.PageOutcome;
import com.atinbo.user.model.UserBO;
import com.atinbo.user.model.UserParam;
import com.atinbo.user.model.UserQueryParam;
import com.atinbo.user.service.UseFeignService;


public class UserServiceFallback  {
    /*@Override
    public Outcome<UserBO> register(UserParam req) {
        return Outcome.<UserBO>ofFail("接口异常");
    }

    @Override
    public PageOutcome<UserBO> findUsers(UserQueryParam param) {
        return PageOutcome.<UserBO>ofFail("接口异常");
    }

    @Override
    public PageOutcome<UserBO> findUsersById(UserQueryParam param) {
        return PageOutcome.<UserBO>ofFail("接口异常");
    }

    @Override
    public Outcome<UserBO> editUsersById(UserParam param) {
        return Outcome.ofFail("接口异常");
    }

    @Override
    public boolean deleteUsers(Long id) {
        return false;
    }*/
}
