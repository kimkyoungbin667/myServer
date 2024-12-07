package com.kkbproject.repository;

import com.kkbproject.dto.BoardDTO;
import com.kkbproject.dto.MemberDTO;
import lombok.RequiredArgsConstructor;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class MemberRepository {

    private final SqlSessionTemplate sql;

        public String login(String userId) {

            return sql.selectOne("Member.login", userId);

            //단일 사용 sql.selectOne();
            //리스트 갖고올땐 sql.selectList();
        }
}
