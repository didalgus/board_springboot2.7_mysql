package org.example.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.example.entity.BoardEntity;

@Mapper
public interface BoardMapper {

    @Select("SELECT seq, title, content, reg_type, reg_name, reg_dt FROM board WHERE seq = #{seq}")
    BoardEntity getBoardBySeq(Long seq);

}
