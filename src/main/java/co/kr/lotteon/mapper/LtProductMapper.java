package co.kr.lotteon.mapper;

import co.kr.lotteon.dto.LtProductDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface LtProductMapper {

    public List<LtProductDTO> selectProducts();

    /* admin 상품 등록 */
    public void insertLtProduct(LtProductDTO ltProductDTO);


}
