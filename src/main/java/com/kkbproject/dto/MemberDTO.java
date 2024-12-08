package com.kkbproject.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class MemberDTO {

    private Long userIdx;          //유저 인덱스 번호
    private String userId;          //유저 아이디
    private String userName;        //유저 이름

    private String userPw;          //유저 비밀번호
    private String email;           //유저 이메일
    private String birth;           //유저 생일
    private String gender;          //유저 성별

}
