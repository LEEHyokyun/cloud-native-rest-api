package com.restapi.user.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@AllArgsConstructor
public class User {

    private Integer userId;

    @Size(min = 3, max = 50, message = "최소 두글자 이상 입력해주세요.")
    private String userName;

    @Past(message = "현재 이전의 날짜만 입력할 수 있습니다.")
    private Date createdAt;

    @JsonIgnore
    private String ssn;
}
