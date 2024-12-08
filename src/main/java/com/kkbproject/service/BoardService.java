package com.kkbproject.service;

import com.kkbproject.dto.BoardDTO;
import com.kkbproject.dto.MemberDTO;
import com.kkbproject.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;

    public List<BoardDTO> findAll() {
        return boardRepository.findAll();
    }

    public BoardDTO detailBoard(int board_idx) {
        return boardRepository.detailBoard(board_idx);
    }

    public int writeBoard(BoardDTO boardDTO) {
        return boardRepository.writeBoard(boardDTO);
    }

    public int deleteBoard(int board_idx) {
        return boardRepository.deleteBoard(board_idx);
    }

    public int reviseBoard(BoardDTO boardDTO) {
        return boardRepository.reviseBoard(boardDTO);
    }
}
