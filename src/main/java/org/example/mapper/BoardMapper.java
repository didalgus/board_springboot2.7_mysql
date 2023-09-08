package org.example.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.example.dto.BoardRegRequest;
import org.example.entity.BoardEntity;

import java.util.List;

@Mapper
public interface BoardMapper {

    @Select("SELECT seq, title, content, reg_name, reg_dt FROM board WHERE seq = #{seq}")
    BoardEntity selectBoardBySeq(Long seq);

    @Insert("INSERT INTO board (title, content, user_id) VALUES (#{title}, #{content}, #{userId})")
    int insertBoard(BoardRegRequest boardRegRequest);

    @Select({"<script>",
            "SELECT seq, title, content, reg_type, reg_name, reg_dt FROM board",
            "<where>",
            "<if test='title != null'> title LIKE CONCAT('%', #{title}, '%')</if>",
            "</where>",
            "</script>"})
    List<BoardEntity> selectBoardList(String title);
}
