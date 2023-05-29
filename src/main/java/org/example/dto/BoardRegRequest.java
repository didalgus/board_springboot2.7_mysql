package org.example.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Setter;
import org.example.enums.RegType;

@Builder
public class BoardRegRequest {

    @ApiModelProperty("제목")
    private String title;

    @ApiModelProperty("내용")
    private String content;

    @ApiModelProperty("글 분류 : 사용자(User), Kafka(Kafka)")
    private RegType regType;

    @ApiModelProperty("등록자이름")
    private String regName;

}
