package org.example.service;

import lombok.extern.slf4j.Slf4j;
import org.example.constants.EnvConstants;
import org.example.dto.BoardRegRequest;
import org.example.entity.BoardEntity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@SpringBootTest
class BoardServiceTest {

    @Autowired
    BoardService boardService;

    @DisplayName("게시물 조회")
    @Test
    void getBoardBySeqTest() {

        BoardEntity boardEntity1 = boardService.getBoardBySeq(1L);
        BoardEntity boardEntity2 = boardService.getBoardBySeq(2L);

        log.info("boardEntity1.getTitle() : {}", boardEntity1.getTitle());
        log.info("boardEntity2.getContent() : {}", boardEntity2.getContent());
        log.info("boardEntity2.getRegDt() : {}", boardEntity2.getRegDt().format(EnvConstants.FORMATTER));

        assertAll(
                () -> assertEquals("title1", boardEntity1.getTitle()),
                () -> assertEquals("content2", boardEntity2.getContent())
        );
    }

    @DisplayName("게시물 목록 조회")
    @Test
    void getBoardListTest() {

        List<BoardEntity> boardEntities = boardService.getBoardList();

        log.info("list count :  {}", boardEntities.size());
        assertTrue(boardEntities.size() > 0);
    }

    @DisplayName("게시물 등록")
    @Test
    void regBoardTest() {

        BoardRegRequest boardRegRequest = BoardRegRequest.builder()
                .title("Dooly")
                .regName("Go Gil-dong")
                .content("baby dinosaur dooly")
                .build();

        String result = boardService.regBoard(boardRegRequest);

        log.info("result : {}", result);
        assertEquals("OK", result);
    }

}