package com.kkbproject.service;

import com.kkbproject.dto.BoardDTO;
import com.kkbproject.dto.MemberDTO;
import com.kkbproject.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

        //로그인
        public Boolean login(String userId, String userPw) {

            String stroedPw = memberRepository.login(userId);

            if(stroedPw != null && stroedPw.equals(userPw)) {
                return true;
            } else {
                return false;
            }


        }

}
