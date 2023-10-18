package co.kr.lotteon.mapper.cs;

import co.kr.lotteon.dto.LtCsCate1DTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface LtCsCate1Mapper {

    public List<LtCsCate1DTO> selectCsCate1();



}
