package co.kr.lotteon.mapper.cs;

import co.kr.lotteon.dto.LtCsNoticeDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface LtCsNoticeMapper {

    List<LtCsNoticeDTO> selectCsNoticeAll();


}
