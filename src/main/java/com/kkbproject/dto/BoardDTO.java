package com.kkbproject.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class BoardDTO {

    private long idx;           //게시판 인덱스
    private String title;       //제목
    private String content;     //내용
    private String deleteYn;    //삭제여부
    private int good;           //좋아요

}
