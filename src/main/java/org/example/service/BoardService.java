package org.example.service;

import org.example.dto.BoardRegRequest;
import org.example.entity.BoardEntity;
import org.example.mapper.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {

    @Autowired
    private BoardMapper boardMapper;

    @Cacheable(cacheNames = "board", key = "#seq")
    public BoardEntity getBoardBySeq(Long seq) {
        return boardMapper.selectBoardBySeq(seq);
    }

    public String regBoard(BoardRegRequest boardRegRequest) {
        return (boardMapper.insertBoard(boardRegRequest) == 1) ? "OK" : "Fail";
    }

    public List<BoardEntity> getBoardList() {
        return boardMapper.selectBoardList();
    }
}
