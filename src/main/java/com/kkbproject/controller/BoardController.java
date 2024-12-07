package com.kkbproject.controller;

import com.kkbproject.dto.BoardDTO;
import com.kkbproject.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3001")
@RequestMapping("/api/board")
public class BoardController {

    private final BoardService boardService;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/findAll")
    @ResponseBody // 반환 데이터를 JSON으로 직렬화
    public List<BoardDTO> findAll() {
        List<BoardDTO> list = boardService.findAll();
        System.out.println("반환된 리스트 : "+list);
        return list;
    }

}
