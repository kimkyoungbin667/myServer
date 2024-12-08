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
import java.util.Map;

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
    public ResponseEntity<ResponseData> detailBoard(int board_idx) {

        ResponseData responseData = new ResponseData();
        BoardDTO detailBoard = boardService.detailBoard(board_idx);
        responseData.setData(detailBoard);

        return ResponseEntity.ok(responseData);
    }

    @PostMapping("/writeBoard")
    @ResponseBody
    public ResponseEntity<ResponseData> writeBoard(@RequestBody BoardDTO boardDTO) {
        ResponseData responseData = new ResponseData();

        System.out.println("추가 : "+boardDTO);
        int writeBoard = boardService.writeBoard(boardDTO);
        responseData.setData(writeBoard);

        if (writeBoard >= 1) {
            return ResponseEntity.ok(responseData);
        } else {
            responseData.setCode("500");
            responseData.setMsg("게시글 추가 실패");
            return ResponseEntity.ok(responseData);
        }

    }

    @PostMapping("/deleteBoard")
    @ResponseBody
    public ResponseEntity<ResponseData> deleteBoard(@RequestBody Map<String, Object> requestData) {
        ResponseData responseData = new ResponseData();

        int board_idx = Integer.parseInt(requestData.get("board_idx").toString());
        int deleteBoard = boardService.deleteBoard(board_idx);

        if (deleteBoard >= 1) {
            return ResponseEntity.ok(responseData);
        } else {
            responseData.setCode("500");
            responseData.setMsg("게시글 삭제 실패");
            return ResponseEntity.ok(responseData);
        }

    }



}
