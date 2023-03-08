package com.ligong.test.pojo;

import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;


@Data
public class User {

    @NotNull(message = "用户名不能为null")
    private String username;

    @Range(max = 120L,min = 0L)
    private Integer age;
    private String address;
}
