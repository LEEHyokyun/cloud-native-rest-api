package com.restapi.user.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "사용자 정보에 대한 도메인 객체")
public class User {

    @Schema(title = "사용자ID", description = "사용자ID는 클러스터링 인덱스에 최적화된 Sequence 기반 생성")
    private Integer userId;

    @Size(min = 3, max = 50, message = "최소 두글자 이상 입력해주세요.")
    private String userName;

    @Past(message = "현재 이전의 날짜만 입력할 수 있습니다.")
    private Date createdAt;

    @JsonIgnore
    private String ssn;
}
