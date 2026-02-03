package com.restapi.user.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@AllArgsConstructor
public class User {

    private Integer userId;
    private String userName;
    private Date createdAt;
}
