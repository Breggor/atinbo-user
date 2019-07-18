package com.atinbo.user.service.impl;

import com.atinbo.core.base.PageInfo;
import com.atinbo.core.service.model.Outcome;
import com.atinbo.core.service.model.PageOutcome;
import com.atinbo.user.entity.User;
import com.atinbo.user.mapper.UserMapper;
import com.atinbo.user.model.UserBO;
import com.atinbo.user.model.UserParam;
import com.atinbo.user.model.UserQueryParam;
import com.atinbo.user.service.UseFeignService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;


/**
 * 用户服务实现
 *
 * @author breggor
 */
@Slf4j
@RestController
@RequestMapping("/users")
@EnableAutoConfiguration
public class UserServiceImpl implements UseFeignService {
    @Autowired
    private UserMapper userMapper;

    /**
     * 增加用户信息
     * @param req
     * @return
     */
    @Override
    public Outcome<UserBO> register(@RequestBody UserParam req) {
        log.info("register 入参===={}", req.toString());
        /*return Outcome.ofSuccess(new UserBO().setAge(30).setNickname("breggor"));*/
        User user=new User();
        user.setNickName(req.getNickname());
        user.setAge(req.getAge());
        User save = userMapper.save(user);
        UserBO userBO=new UserBO();
        userBO.setNickname(save.getNickName());
        userBO.setAge(save.getAge());
        return Outcome.ofSuccess(userBO);
    }

    /**
     * 查找用户信息
     * @param param
     * @return
     */
    @Override
    public PageOutcome<UserBO> findUsers(UserQueryParam param) {
        List<UserBO> list=new ArrayList<>();
        UserBO userBO=new UserBO();
        List<User> all = userMapper.findAll();
        for (User a:all) {
            userBO.setNickname(a.getNickName());
            userBO.setAge(a.getAge());
            list.add(userBO);
        }
        return PageOutcome.ofSuccess(PageInfo.of(1, 10, 10, 100), list);
    }

    /**
     * 通过多条件查询
     * @param param
     * @return
     */
    @Override
    public PageOutcome<UserBO> findUsersByCondition(UserQueryParam param) {
        List<User> all = userMapper.findAll(new Specification<User>() {
            @Override
            public Predicate toPredicate(Root<User> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                List<Predicate> list = new ArrayList<>();
                if (StringUtils.isNoneBlank(param.getNickname())) {
                    list.add(cb.equal(root.get("nickname"), param.getNickname()));
                }
                if (param.getAge() != null) {
                    list.add(cb.equal(root.get("age"), param.getAge()));
                }
                Predicate[] p = new Predicate[list.size()];

                return cb.and(list.toArray(p));
            }
        });
        UserBO userBO=new UserBO();
        List<UserBO> list=new ArrayList<>();
        for (User a:all) {
            userBO.setNickname(a.getNickName());
            userBO.setAge(a.getAge());
            list.add(userBO);
        }
        return PageOutcome.ofSuccess(PageInfo.of(1, 10, 10, 100), list);
    }

    /**
     * 根据id查找用户信息
     * @param param
     * @return
     */
    @Override
    public PageOutcome<UserBO> findUsersById(UserQueryParam param) {
        List<UserBO> list = new ArrayList<>();
        User one = userMapper.getOne(param.getId());
        UserBO userBO=new UserBO();
        userBO.setNickname(one.getNickName());
        userBO.setAge(one.getAge());
        list.add(userBO);
        return PageOutcome.ofSuccess(PageInfo.of(1, 10, 10, 100), list);
    }

    /**
     * 修改用户信息
     * @param param
     * @return
     */
    @Override
    public Outcome<UserBO> editUsersById(UserParam param) {
        User one = userMapper.getOne(param.getId());
       UserBO userBO=new UserBO();
        one.setNickName(param.getNickname());
        one.setAge(param.getAge());
        User user = userMapper.saveAndFlush(one);
        userBO.setNickname(user.getNickName());
        userBO.setAge(user.getAge());
        return Outcome.ofSuccess(userBO);
    }

    /**
     * 删除用户信息
     * @param param
     * @return
     */

    @Override
    public boolean deleteUsers(UserParam param) {
        userMapper.deleteById(param.getId());
        return true;
    }


}
