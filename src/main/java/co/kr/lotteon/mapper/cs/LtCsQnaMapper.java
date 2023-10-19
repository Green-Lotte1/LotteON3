package co.kr.lotteon.mapper.cs;

import co.kr.lotteon.dto.LtCsQnaDTO;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface LtCsQnaMapper {

    public void insertQnaWrite(LtCsQnaDTO dto);



}
