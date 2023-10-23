package co.kr.lotteon.service;


import co.kr.lotteon.dto.LtCsNoticeDTO;
import co.kr.lotteon.dto.LtMemberDTO;
import co.kr.lotteon.dto.cspage.CsPageRequestDTO;
import co.kr.lotteon.dto.cspage.CsPageResponseDTO;
import co.kr.lotteon.entity.LtCsNoticeEntity;
import co.kr.lotteon.entity.LtMemberEntity;
import co.kr.lotteon.entity.LtProductEntity;
//import co.kr.lotteon.mapper.LtCsNoticeMapper;
import co.kr.lotteon.repository.LtCsNoticeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AdminCsService {

    @Autowired
    LtCsNoticeRepository ltCsNoticeRepository;

    public void saveNotice(LtCsNoticeDTO dto){

        // DTO를 Entity로 변환
        LtCsNoticeEntity entity = dto.toEntity();

        // DB insert
        ltCsNoticeRepository.save(entity);
    }

    public List<LtCsNoticeDTO> noticeList(){

        return ltCsNoticeRepository.findAll()
                .stream()
                .map(
                        LtCsNoticeEntity::toDTO
                )
                .collect(Collectors.toList());
    }


    public CsPageResponseDTO noticeList(CsPageRequestDTO pageRequestDTO){
        Pageable pageable = pageRequestDTO.getPageable("noticeNo");
        Page<LtCsNoticeEntity> result = null;
        if(pageRequestDTO.getCate1() == 0){
           result = ltCsNoticeRepository.findAll(pageable);
        } else{
           result = ltCsNoticeRepository.findAllByCate1(pageRequestDTO.getCate1(), pageable);
        }
        List<LtCsNoticeDTO> dtoList = result.getContent()
                .stream()
                .map(
                        LtCsNoticeEntity::toDTO
                )
                .toList();
        //.collect(Collectors.toList());
        int totalElement = (int) result.getTotalElements();
        return CsPageResponseDTO.builder()
                .pageRequestDTO(pageRequestDTO)
                .noticeList(dtoList)
                .total(totalElement)
                .build();
    }


}