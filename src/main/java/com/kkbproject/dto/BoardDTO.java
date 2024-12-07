package com.kkbproject.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Setter
@Getter
@ToString
public class BoardDTO {

    private Integer idx;            //게시판 인덱스
    private String title;           //제목
    private String content;         //내용
    private String createBy;     //작성자
    private LocalDateTime created;  //생성일
    private String deleteYn;        //삭제여부
    private Integer good;           //좋아요

}
