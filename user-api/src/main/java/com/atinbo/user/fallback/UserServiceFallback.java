package com.atinbo.user.fallback;

import com.atinbo.core.service.model.Outcome;
import com.atinbo.core.service.model.PageOutcome;
import com.atinbo.user.model.UserBO;
import com.atinbo.user.model.UserParam;
import com.atinbo.user.model.UserQueryParam;
import com.atinbo.user.service.UserService;


public class UserServiceFallback implements UserService {
    @Override
    public Outcome<UserBO> register(UserParam req) {
        return Outcome.<UserBO>ofFail("接口异常");
    }

    @Override
    public PageOutcome<UserBO> findUsers(UserQueryParam param) {
        return PageOutcome.<UserBO>ofFail("接口异常");
    }
}
