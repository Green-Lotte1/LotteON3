package co.kr.lotteon.mapper;

import co.kr.lotteon.dto.LtProductDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface LtProductMapper {

    public List<LtProductDTO> selectProducts();

    /* admin 상품 등록 */
    public void insertLtProduct(LtProductDTO ltProductDTO);


    /* admin 상품 삭제 */
    public void deleteLtProduct(int prodNo);

    /* admin 상품 조회 1개 */
    public LtProductDTO selectProduct(int prodNo);

}
