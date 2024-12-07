package com.kkbproject.controller;

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
@CrossOrigin(origins = "http://localhost:3001")
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/login")
    public ResponseEntity<Map<String, Object>> login(@RequestBody Map<String, String> loginData) {

        String userId = loginData.get("userId");
        String userPw = loginData.get("userPw");

        Boolean loginStatus = memberService.login(userId, userPw);

        if (loginStatus) {
            return ResponseEntity
                    .ok(Map.of(
                            "status", "success"
                    ));
        } else {
            return ResponseEntity
                    .status(HttpStatus.UNAUTHORIZED) // 401 Unauthorized 상태 코드 설정
                    .body(Map.of(
                            "status", "fail",
                            "message", "Invalid username or password"
                    ));
        }

    }
}
