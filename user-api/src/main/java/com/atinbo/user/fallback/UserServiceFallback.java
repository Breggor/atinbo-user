package com.atinbo.user.fallback;

import com.atinbo.user.model.UserReq;
import com.atinbo.user.model.UserRes;
import com.atinbo.user.service.UserService;


public class UserServiceFallback implements UserService {
    @Override
    public UserRes register(UserReq req) {
        return null;
    }
}
