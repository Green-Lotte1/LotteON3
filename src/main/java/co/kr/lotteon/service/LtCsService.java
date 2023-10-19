package co.kr.lotteon.service;

import co.kr.lotteon.dto.*;
import co.kr.lotteon.mapper.cs.LtCsCateMapper;
import co.kr.lotteon.mapper.cs.LtCsIndexMapper;
import co.kr.lotteon.mapper.cs.LtCsNoticeMapper;
import co.kr.lotteon.mapper.cs.LtCsQnaMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;
@RequiredArgsConstructor
@Service
@Log4j2
public class LtCsService {



    private final LtCsIndexMapper ltCsIndexMapper;

    private final LtCsCateMapper ltCsCateMapper;

    private final LtCsQnaMapper ltCsQnaMapper;

    private final LtCsNoticeMapper ltCsNoticeMapper;


    public List<LtCsNoticeDTO> selectCsNotices(){
        return ltCsIndexMapper.selectCsNotices();
    }

    public List<LtCsQnaDTO> selectCsQna(){
        return ltCsIndexMapper.selectCsQna();
    }

    public List<LtCsCate1DTO> selectCsCate1(){
        return ltCsCateMapper.selectCsCate1();
    }

    public List<LtCsCate2DTO> selectCsCate2(int cate1){
        return ltCsCateMapper.selectCsCate2(cate1);
    }

    public void insertQnaWrite(LtCsQnaDTO dto){
        ltCsQnaMapper.insertQnaWrite(dto);
    }

    public List<LtCsNoticeDTO> selectCsNoticeAll(){
        return ltCsNoticeMapper.selectCsNoticeAll();
    }






}
