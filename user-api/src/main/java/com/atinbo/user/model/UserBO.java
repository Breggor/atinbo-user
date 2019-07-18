package com.atinbo.user.model;

import com.atinbo.core.service.model.BaseBO;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
@Accessors(chain = true)
public class UserBO implements BaseBO {
    @Id
    private Long id;
    private String nickname;
    private Integer age;
}
