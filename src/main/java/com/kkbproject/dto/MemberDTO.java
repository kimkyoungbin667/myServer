package com.kkbproject.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class MemberDTO {

    private int idx;
    private String userId;
    private String userName;
    private String userPw;
    private String email;
    private String birth;
    private String gender;

}
