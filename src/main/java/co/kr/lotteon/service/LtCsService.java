package co.kr.lotteon.service;

import co.kr.lotteon.dto.LtCsCate1DTO;
import co.kr.lotteon.dto.LtCsNoticeDTO;
import co.kr.lotteon.dto.LtCsQnaDTO;
import co.kr.lotteon.mapper.cs.LtCsCate1Mapper;
import co.kr.lotteon.mapper.cs.LtCsIndexMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;
@RequiredArgsConstructor
@Service
@Log4j2
public class LtCsService {



    private final LtCsIndexMapper ltCsIndexMapper;

    private final LtCsCate1Mapper ltCsCate1Mapper;


    public List<LtCsNoticeDTO> selectCsNotices(){
        return ltCsIndexMapper.selectCsNotices();
    }

    public List<LtCsQnaDTO> selectCsQna(){
        return ltCsIndexMapper.selectCsQna();
    }

    public List<LtCsCate1DTO> selectCsCate1(){
        return ltCsCate1Mapper.selectCsCate1();
    }




}
