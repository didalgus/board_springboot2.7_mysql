package org.example.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import org.example.enums.RegType;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Builder
public class BoardRegRequest {

    @ApiModelProperty("제목")
    @NotEmpty(message = "Please enter a title")
    private String title;

    @ApiModelProperty("내용")
    @NotEmpty(message = "Please enter your content")
    private String content;

    @ApiModelProperty("글 분류 : 사용자(User), Kafka(Kafka)")
    private RegType regType;

    @ApiModelProperty("등록자이름")
    @NotEmpty(message = "Please enter your name")
    private String regName;

}
