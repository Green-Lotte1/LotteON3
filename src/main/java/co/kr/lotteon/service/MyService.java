package co.kr.lotteon.service;

import co.kr.lotteon.dto.LtMemberPointDTO;
import co.kr.lotteon.dto.LtProductOrderDTO;
import co.kr.lotteon.dto.LtProductOrderItemDTO;
import co.kr.lotteon.dto.mypage.MyOrdersDTO;
import co.kr.lotteon.dto.mypage.MyPageRequestDTO;
import co.kr.lotteon.dto.mypage.MyPageResponseDTO;
import co.kr.lotteon.entity.LtMemberPointEntity;
import co.kr.lotteon.entity.LtProductOrderEntity;
import co.kr.lotteon.entity.LtProductOrderItemEntity;
import co.kr.lotteon.repository.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    public MyPageResponseDTO showPoint(MyPageRequestDTO pageRequestDTO, String uid){
        Pageable pageable = pageRequestDTO.getPageable("pointNo", 10);
        Page<LtMemberPointEntity> result = null;
        result = ltMemberPointRepository.findAllByUid(uid, pageable);
        List<LtMemberPointDTO> dtoList = result.getContent()
                .stream().
                map(
                        LtMemberPointEntity::toDTO
                )
                .toList();
        int totalElement = (int) result.getTotalElements();
        return MyPageResponseDTO.builder()
                .pageRequestDTO(pageRequestDTO)
                .pointList(dtoList)
                .total(totalElement)
                .build();
    }

    public MyPageResponseDTO showOrder(MyPageRequestDTO pageRequestDTO, String ordUid){
        Pageable pageable = pageRequestDTO.getPageable("ordNo", 5);
        Page<LtProductOrderEntity> result = null;
        result = ltProductOrderRepository.findAllByOrdUid(ordUid, pageable);
        List<MyOrdersDTO> myOrdersDTOList = new ArrayList<>();
        List<LtProductOrderDTO> orderList = result.getContent()
                .stream().
                map(
                       entity -> modelMapper.map(entity, LtProductOrderDTO.class)
                )
                .toList();
        for(LtProductOrderDTO dto : orderList){
            log.info("myOrder DTO : " + dto);
            List<LtProductOrderItemDTO> itemList = ltProductOrderItemRepository.findAllByLtProductOrderItemPK_OrdNo(dto.getOrdNo())
                    .stream()
                    .map(LtProductOrderItemEntity::toDTO)
                    .toList();
            MyOrdersDTO myOrders = new MyOrdersDTO(dto, itemList);
            myOrdersDTOList.add(myOrders);
            log.info("myOrders CLASS : " + myOrders);
        }
        int totalElement = (int) result.getTotalElements();
        return MyPageResponseDTO.builder()
                .pageRequestDTO(pageRequestDTO)
                .myOrdersDTOList(myOrdersDTOList)
                .total(totalElement)
                .build();
    }

}
