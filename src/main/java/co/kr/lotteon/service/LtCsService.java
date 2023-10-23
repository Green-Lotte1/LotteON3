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




    // notice,qna List Mybatis 로 페이징 만들기

    // 현재 페이지 번호
    public int getCurrentPage(String pg) {
        int currentPage = 1;

        if(pg != null){
            currentPage = Integer.parseInt(pg);
        }

        return currentPage;
    }

    // Notice게시판 총 갯수 카운트
    public int selectCsNoticeTotal() {
        return ltCsNoticeMapper.selectCsNoticeTotal();
    }
    // Notice게시판 cate 참고한 총 갯수 카운트
    public int selectCsNoticeTotalCate(int cate1){
        return ltCsNoticeMapper.selectCsNoticeTotalCate(cate1);
    }

    // Qna게시판 총 갯수 카운트
    public int selectCsQnaTotal() {
        return ltCsQnaMapper.selectCsQnaTotal();
    }

    // 페이지 마지막 번호
    public int getLastPageNum(int total) {

        int lastPageNum = 0;

        if(total % 10 == 0){
            lastPageNum = total / 10;
        }else{
            lastPageNum = total / 10 + 1;
        }
        log.info("lastPageNum--------"+lastPageNum);
        return lastPageNum;

    }

    // 페이지 그룹
    public int[] getPageGroupNum(int currentPage, int lastPageNum) {
        int currentPageGroup = (int)Math.ceil(currentPage / 10.0);
        int pageGroupStart = (currentPageGroup - 1) * 10 + 1;
        int pageGroupEnd = currentPageGroup * 10;

        if(pageGroupEnd > lastPageNum){
            pageGroupEnd = lastPageNum;
        }

        int[] result = {pageGroupStart, pageGroupEnd};

        return result;
    }

    // 페이지 시작번호
    public int getPageStartNum(int total, int currentPage) {
        int start = (currentPage - 1) * 10;
        return total - start;
    }

    // Limit 시작번호
    public int getStartNum(int currentPage) {
        return (currentPage - 1) * 10;
    }

    //noticeList 전체
    public List<LtCsNoticeDTO> selectCsNoticeListAll(int start){
        return ltCsNoticeMapper.selectCsNoticeListAll(start);
    }
    //noticeList cate 참조
    public List<LtCsNoticeDTO> selectCsNoticeListCate(int cate1, int start){
        return ltCsNoticeMapper.selectCsNoticeListCate(cate1, start);
    }

    public List<LtCsQnaDTO> selectCsQnaListAll(int start){
        return ltCsQnaMapper.selectCsQnaListAll(start);
    }

    // 게시판 view

    public LtCsNoticeDTO selectCSNoticeView(int noticeNo){
        return ltCsNoticeMapper.selectCSNoticeView(noticeNo);
    }

    public LtCsQnaDTO selectCsQnaView(int qnaNo){
        return ltCsQnaMapper.selectCsQnaView(qnaNo);
    }




}
