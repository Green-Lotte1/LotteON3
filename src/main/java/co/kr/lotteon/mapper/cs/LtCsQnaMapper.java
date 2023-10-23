package co.kr.lotteon.mapper.cs;

import co.kr.lotteon.dto.LtCsQnaDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface LtCsQnaMapper {

    public void insertQnaWrite(LtCsQnaDTO dto);

    List<LtCsQnaDTO> selectCsQnaListAll(int start);

    public int selectCsQnaTotal();

    public LtCsQnaDTO selectCsQnaView(int qnaNo);

}
