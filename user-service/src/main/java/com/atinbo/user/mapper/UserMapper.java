package com.atinbo.user.mapper;

import com.atinbo.user.model.UserBO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper extends JpaRepository<UserBO, Long>, JpaSpecificationExecutor<UserBO> {
}
