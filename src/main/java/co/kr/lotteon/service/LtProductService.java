package co.kr.lotteon.service;

import co.kr.lotteon.dto.LtProductDTO;
import co.kr.lotteon.entity.LtProductEntity;
import co.kr.lotteon.mapper.LtProductMapper;
import co.kr.lotteon.repository.LtProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

}
