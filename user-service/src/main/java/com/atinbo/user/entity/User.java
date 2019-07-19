package com.atinbo.user.entity;

import com.atinbo.user.base.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Where;

import javax.persistence.*;

/**
 * @author 陈路嘉
 */
@Data
@Entity
@JsonIgnoreProperties
@Table(name = "user")
@Where(clause = "deleted = 0")
@EqualsAndHashCode
@DynamicInsert
@DynamicUpdate
public class User extends BaseEntity {
    //用户Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //用户名称
    private String nickName;
    //用户年龄
    private Integer age;
}
