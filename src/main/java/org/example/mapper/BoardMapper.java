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

    @Insert("INSERT INTO board (title, content, reg_name) VALUES (#{title}, #{content}, #{regName})")
    int insertBoard(BoardRegRequest boardRegRequest);

    @Select("SELECT seq, title, content, reg_name, reg_dt FROM board")
    List<BoardEntity> selectBoardList();
}
