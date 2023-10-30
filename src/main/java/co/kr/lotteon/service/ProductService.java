package co.kr.lotteon.service;

import co.kr.lotteon.dto.LtCsNoticeDTO;
import co.kr.lotteon.dto.LtProductDTO;
import co.kr.lotteon.dto.LtProductReviewDTO;
import co.kr.lotteon.dto.cspage.CsPageRequestDTO;
import co.kr.lotteon.dto.cspage.CsPageResponseDTO;
import co.kr.lotteon.dto.mypage.MyPageRequestDTO;
import co.kr.lotteon.dto.mypage.MyPageResponseDTO;
import co.kr.lotteon.dto.prodpage.ProdPageRequestDTO;
import co.kr.lotteon.dto.prodpage.ProdPageResponseDTO;
import co.kr.lotteon.entity.LtCsNoticeEntity;
import co.kr.lotteon.entity.LtProductEntity;
import co.kr.lotteon.entity.LtProductReviewEntity;
import co.kr.lotteon.mapper.LtProductMapper;
import co.kr.lotteon.repository.LtProductRepository;
import co.kr.lotteon.repository.LtProductReviewRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Log4j2
@Service
@RequiredArgsConstructor
public class ProductService {

    private final LtProductRepository ltProductRepository;
    private final LtProductReviewRepository ltProductReviewRepository;


    // 카테고리별 리스트
    public ProdPageResponseDTO getProductListByCates(ProdPageRequestDTO pageRequestDTO) {
        Pageable pageable = pageRequestDTO.getPageable("prodNo");
        Page<LtProductEntity> result = ltProductRepository.findAllByProdCate1AndProdCate2(pageRequestDTO.getCate1(), pageRequestDTO.getCate2(), pageable);
        List<LtProductDTO> dtoList = result.getContent()
                .stream()
                .map(
                        LtProductEntity::toDTO
                )
                .toList();
        int totalElement = (int) result.getTotalElements();
        return ProdPageResponseDTO.builder()
                .pageRequestDTO(pageRequestDTO)
                .dtoList(dtoList)
                .total(totalElement)
                .build();
    }

    public MyPageResponseDTO getReviews(int prodNo, MyPageRequestDTO pageRequestDTO) {
        Pageable pageable = pageRequestDTO.getPageable("rdate", 10);





        Page<LtProductReviewEntity> result = null;
        result = ltProductReviewRepository.findAllByLtProductEntity(LtProductEntity.builder().prodNo(prodNo).build(), pageable);
        List<LtProductReviewDTO> dtoList = result
                .stream().map(LtProductReviewEntity::toDTO).toList();

        int totalElement = (int) result.getTotalElements();
        return MyPageResponseDTO.builder()
                .pageRequestDTO(pageRequestDTO)
                .reviewList(dtoList)
                .total(totalElement)
                .build();
    }
}
