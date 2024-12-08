package com.kkbproject.controller;

import com.kkbproject.ResponseData.ResponseData;
import com.kkbproject.dto.BoardDTO;
import com.kkbproject.dto.MemberDTO;
import com.kkbproject.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
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

    @GetMapping("/detailBoard")
    @ResponseBody
    public ResponseEntity<ResponseData> detailBoard(Integer board_idx) {

        System.out.println("디테일 호출");
        System.out.println("dawdwa"+board_idx);
        ResponseData responseData = new ResponseData();
        BoardDTO detailBoard = boardService.detailBoard(board_idx);
        responseData.setData(detailBoard);

        return ResponseEntity.ok(responseData);
    }

    @PostMapping("/writeBoard")
    @ResponseBody
    public ResponseEntity<ResponseData> writeBoard(@RequestBody BoardDTO boardDTO) {
        ResponseData responseData = new ResponseData();

        System.out.println(boardDTO);
        int writeBoard = boardService.writeBoard(boardDTO);
        responseData.setData(writeBoard);

        return ResponseEntity.ok(responseData);
    }



}
