package co.kr.lotteon.service;

import co.kr.lotteon.dto.LtMemberPointDTO;
import co.kr.lotteon.dto.mypage.PointPageRequestDTO;
import co.kr.lotteon.dto.mypage.PointPageResponseDTO;
import co.kr.lotteon.entity.LtMemberPointEntity;
import co.kr.lotteon.repository.*;
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
public class MyService {

    private final LtProductRepository ltProductRepository;
    private final LtProductCartRepository ltProductCartRepository;
    private final LtProductOrderRepository ltProductOrderRepository;
    private final LtProductOrderItemRepository ltProductOrderItemRepository;
    private final LtMemberRepository ltMemberRepository;
    private final LtMemberPointRepository ltMemberPointRepository;
    private final ModelMapper modelMapper;

    public PointPageResponseDTO showPoint(PointPageRequestDTO pageRequestDTO, String uid){
        Pageable pageable = pageRequestDTO.getPageable("pointNo");
        Page<LtMemberPointEntity> result = null;
        result = ltMemberPointRepository.findAllByUid(uid, pageable);
        List<LtMemberPointDTO> dtoList = result.getContent()
                .stream().
                map(
                        entity -> modelMapper.map(entity, LtMemberPointDTO.class)
                )
                .toList();
        int totalElement = (int) result.getTotalElements();
        return PointPageResponseDTO.builder()
                .pageRequestDTO(pageRequestDTO)
                .pointList(dtoList)
                .total(totalElement)
                .build();
    }

}
