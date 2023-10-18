package co.kr.lotteon.mapper.admin;

import co.kr.lotteon.dto.LtProductCate1DTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface LtProductCateMapper {

    public List<LtProductCate1DTO> selectLtProductCate1s();

//    public List<LtProductCate2DTO> selectLtProductCate2s();

}
