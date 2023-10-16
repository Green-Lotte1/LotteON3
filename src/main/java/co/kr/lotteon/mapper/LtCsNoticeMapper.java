package co.kr.lotteon.mapper;

import co.kr.lotteon.dto.LtCsNoticeDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface LtCsNoticeMapper {

    public List<LtCsNoticeDTO> selectCsNotices();


}
