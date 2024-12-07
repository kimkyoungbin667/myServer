package com.kkbproject.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class MemberDTO {

    private Long idx;
    private String userId;
    private String userName;
    private Long createBy;
    private String userPw;
    private String email;
    private String birth;
    private String gender;

}
