package org.example.controller;

import org.example.constants.EnvConstants;
import org.example.dto.BoardRegRequest;
import org.example.dto.BoardResponse;
import org.example.entity.BoardEntity;
import org.example.enums.RegType;
import org.example.service.BoardService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
class BoardRestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BoardService boardService;

    @Test
    void getBoardSeqContent() {
    }

    @DisplayName("게시물 조회")
    @Test
    void getBoardSeqTest() throws Exception {

        when(boardService.getBoardBySeq(any())).thenReturn(getBoardEntity());

        mockMvc.perform(get("/board/2")
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                        .andExpect(status().isOk())
                        .andExpect(jsonPath("$.seq").value(2))
                        .andDo(print());

    }

    @DisplayName("게시물 목록 조회")
    @Test
    void getBoardListTest() throws Exception {
        when(boardService.getBoardList())
                .thenReturn(Collections.singletonList(getBoardEntity()));

        mockMvc.perform(get("/board/list")
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                        .andExpect(status().isOk())
                        .andDo(print());

    }

    @DisplayName("게시물 등록")
    @Test
    void regBoardTest() throws Exception {
        given(boardService.regBoard(any()))
                .willReturn("OK");

        mockMvc.perform(
                MockMvcRequestBuilders.post("/board/reg")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(getBoardRegRequest().toString()))
                .andExpect(status().is2xxSuccessful())
                .andDo(print());

    }


    private BoardRegRequest getBoardRegRequest() {
        return BoardRegRequest.builder()
                .title("Dooly")
                .regName("Go Gil-dong")
                .content("baby dinosaur dooly")
                .build();
    }

    private BoardEntity getBoardEntity() {
        return BoardEntity.builder()
                .seq(2L)
                .regName("Go gil-dong")
                .title("Dooly")
                .content("baby dinosaur dooly")
                .regType(RegType.User)
                .regDt(LocalDateTime.now())
                .build();
    }

}