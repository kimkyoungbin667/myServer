package com.kkbproject.controller;

import com.kkbproject.ResponseData.ResponseData;
import com.kkbproject.dto.BoardDTO;
import com.kkbproject.dto.MemberDTO;
import com.kkbproject.repository.MemberRepository;
import com.kkbproject.service.MemberService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@RequiredArgsConstructor
@RequestMapping("/api/member")
@CrossOrigin(origins = "http://localhost:3000")
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/login")
    public ResponseEntity<ResponseData> login(@RequestBody MemberDTO member) {

        ResponseData responseData = new ResponseData();
        System.out.println(member);
        String userId = member.getUserId();
        String userPw = member.getUserPw();

        Boolean loginStatus = memberService.login(userId, userPw);

        if (loginStatus) {
            responseData.setData(memberService.getUserInfo(userId));
            return ResponseEntity.ok(responseData);
        } else {
            responseData.setCode("500");
            responseData.setMsg("로그인 실패");
            return ResponseEntity.ok(responseData);
        }
    }


}
