package org.example.controller;

import org.example.constants.EnvConstants;
import org.example.dto.BoardResponse;
import org.example.entity.BoardEntity;
import org.example.enums.RegType;
import org.example.service.BoardService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import java.time.LocalDateTime;
import static org.mockito.ArgumentMatchers.any;
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

    @Test
    void getBoardSeqContentTest() throws Exception {

        when(boardService.getBoardBySeq(any())).thenReturn(getBoardEntity());

        mockMvc.perform(get("/board/2/content")
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.seq").value(2))
                .andDo(print());

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

    private BoardResponse getBoardResponse() {
        return BoardResponse.builder()
                .seq(1L)
                .regName("Go gil-dong")
                .title("Dooly")
                .content("baby dinosaur dooly")
                .regType(RegType.User)
                .regDt(LocalDateTime.now().format(EnvConstants.FORMATTER).toString())
                .build();
    }
}