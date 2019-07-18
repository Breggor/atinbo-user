package com.atinbo.user.entity;

import com.atinbo.user.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Where;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "user")
@Where(clause = "deleted = 0")
@EqualsAndHashCode
@DynamicInsert
@DynamicUpdate
public class User extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nickName;
    private Long age;
}
