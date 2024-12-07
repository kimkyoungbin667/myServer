package com.kkbproject.repository;

import com.kkbproject.dto.BoardDTO;
import com.kkbproject.dto.MemberDTO;
import lombok.RequiredArgsConstructor;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class BoardRepository {

    private final SqlSessionTemplate sql;

    public List<BoardDTO> findAll() {
        return sql.selectList("Board.findAll");
    }

    public BoardDTO detailBoard(int idx) {
        return sql.selectOne("Board.detailBoard", idx);
    }
}
