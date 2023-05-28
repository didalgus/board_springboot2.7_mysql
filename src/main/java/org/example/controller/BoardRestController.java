package org.example.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.dto.BoardResponse;
import org.example.service.BoardService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@Api(tags = "Board")
@RestController
@RequiredArgsConstructor
public class BoardRestController {

    private final BoardService boardService;

    @ApiOperation("게시물 조회")
    @GetMapping("/board/{boardSeq}/content")
    public BoardResponse getBoardSeqContent(@PathVariable Long boardSeq) {
        return BoardResponse.of(boardService.getBoardBySeq(boardSeq));
    }

}
