package com.atinbo.user.model;

import com.atinbo.core.service.model.BaseBO;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Accessors(chain = true)
public class UserBO implements BaseBO {
    private Long id;
    private String nickname;
    private Integer age;
}
