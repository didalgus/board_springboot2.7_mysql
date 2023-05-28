package org.example.service;

import lombok.extern.slf4j.Slf4j;
import org.example.constants.EnvConstants;
import org.example.entity.BoardEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
@SpringBootTest
class BoardServiceTest {

    @Autowired
    BoardService boardService;

    @Test
    void getBoardBySeq() {

        BoardEntity boardEntity1 = boardService.getBoardBySeq(1L);
        BoardEntity boardEntity2 = boardService.getBoardBySeq(2L);

        log.info("boardEntity1.getTitle() : {}", boardEntity1.getTitle());
        log.info("boardEntity2.getContent() : {}", boardEntity2.getContent());
        log.info("boardEntity2.getRegType() : {}", boardEntity2.getRegType());
        log.info("boardEntity2.getRegName() : {}", boardEntity2.getRegName());
        log.info("boardEntity2.getRegDt() : {}", boardEntity2.getRegDt().format(EnvConstants.FORMATTER));

        assertAll(
                () -> assertEquals("title1", boardEntity1.getTitle()),
                () -> assertEquals("content2", boardEntity2.getContent())
        );
    }
}