package org.example.service;

import org.example.entity.BoardEntity;
import org.example.mapper.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class BoardService {

    @Autowired
    private BoardMapper boardMapper;

    @Cacheable(cacheNames = "board", key = "#seq")
    public BoardEntity getBoardBySeq(Long seq) {
        return boardMapper.getBoardBySeq(seq);
    }
}
