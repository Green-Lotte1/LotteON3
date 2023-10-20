package co.kr.lotteon.service;

import co.kr.lotteon.dto.LtProductCartDTO;
import co.kr.lotteon.dto.LtProductDTO;
import co.kr.lotteon.entity.LtProductCartEntity;
import co.kr.lotteon.entity.LtProductEntity;
import co.kr.lotteon.mapper.LtProductMapper;
import co.kr.lotteon.repository.LtProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Log4j2
@Service
@RequiredArgsConstructor
public class LtProductService {

    private final LtProductRepository ltProductRepository;
    private final LtProductMapper ltProductMapper;
    private final ModelMapper modelMapper;

//    상품 리스트 출력(list)
    public List<LtProductDTO> selectProducts() {
        return ltProductMapper.selectProducts();
    }

//    상품 선택 상세페이지 (view)
    public LtProductDTO getProdDto(int prodNo) {
        LtProductEntity entity = ltProductRepository.findById(prodNo).get();
        return entity.toDTO();
    }

//    admin - 상품 등록
    public void insertLtProduct(LtProductDTO ltProductDTO){
        System.out.println("ltProductDTO : " + ltProductDTO);
        ltProductDTO.setRDate(LocalDateTime.now());
        ltProductDTO.setIsRemoved(1);
        ltProductMapper.insertLtProduct(ltProductDTO);
    }

}
