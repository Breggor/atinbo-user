package com.atinbo.user.service.impl;

import com.atinbo.core.base.PageInfo;
import com.atinbo.core.service.model.Outcome;
import com.atinbo.core.service.model.PageOutcome;
import com.atinbo.user.entity.User;
import com.atinbo.user.mapper.UserMapper;
import com.atinbo.user.model.UserBO;
import com.atinbo.user.model.UserParam;
import com.atinbo.user.model.UserQueryParam;
import com.atinbo.user.repository.UserRepository;
import com.atinbo.user.service.UseService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * 用户服务实现
 *
 * @author 陈路嘉
 */
@Slf4j
@RestController
@RequestMapping("/users")
public class UserServiceImpl implements UseService {
    @Autowired
    private UserRepository userRepository;

    /**
     * 增加用户信息
     *
     * @param param
     * @return
     */
    @Override
    public Outcome<UserBO> register(@RequestBody UserParam param) {
        User user = UserMapper.INSTANCE.toUser(param);
        user.setCreateAt(new Date());
        userRepository.save(user);
        UserBO userBo = UserMapper.INSTANCE.toUserBO(user);
        return Outcome.ofSuccess(userBo);
    }

    /**
     * 通过多条件查询
     *
     * @param param
     * @return
     */
    @Override
    public PageOutcome<UserBO> findAllByPage(UserQueryParam param) {
        String direction = param.getDirection();
        if (StringUtils.isBlank(direction)) {
            direction = "ASC";
        }
        Sort.Direction direction1 = Sort.Direction.fromString(direction);
        Sort sort = new Sort(direction1, param.getProperty());
        PageRequest pageRequest = PageRequest.of(param.getPage(), param.getSize(), sort);
        Page<User> page = userRepository.findAll(new Specification<User>() {
            @Override
            public Predicate toPredicate(Root<User> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                List<Predicate> list = new ArrayList<>();
                if (StringUtils.isNotBlank(param.getNickname())) {
                    list.add(cb.equal(root.get("nickName"), param.getNickname()));
                }
                if (param.getAge() != null) {
                    list.add(cb.equal(root.get("age"), param.getAge()));
                }
                Predicate[] p = new Predicate[list.size()];
                return cb.and(list.toArray(p));
            }
        }, pageRequest);
        List<UserBO> userBOs = UserMapper.INSTANCE.toUserBOs(page.getContent());
        return PageOutcome.ofSuccess(PageInfo.of(page.getNumber(), page.getTotalPages(), page.getSize(), (int) page.getTotalElements()), userBOs);
    }

    /**
     * 根据id查找用户信息
     *
     * @return
     */
    @Override
    public UserBO findUsersById(Long userId) {
        User one = userRepository.getOne(userId);
        UserBO userBo = UserMapper.INSTANCE.toUserBO(one);
        return userBo;
    }

    /**
     * 修改用户信息
     *
     * @param
     * @return
     */
    @Override
    public Outcome<UserBO> editUsersById(Long userId, UserParam param) {
        User user = UserMapper.INSTANCE.toUpdateUser(param, userRepository.getOne(userId));
        userRepository.saveAndFlush(user);
        UserBO userBo = UserMapper.INSTANCE.toUserBO(user);
        return Outcome.ofSuccess(userBo);
    }

    /**
     * 删除用户信息
     *
     * @return
     */
    @Override
    public boolean deleteUserById(Long userId) {
        userRepository.deleteById(userId);
        return true;
    }

}
