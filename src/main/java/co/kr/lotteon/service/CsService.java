package co.kr.lotteon.service;

import co.kr.lotteon.dto.LtCsNoticeDTO;
import co.kr.lotteon.mapper.LtCsNoticeMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
@RequiredArgsConstructor
@Service
@Log4j2
public class CsService {



    private final LtCsNoticeMapper ltCsNoticeMapper;

    private final ModelMapper modelMapper;

    public List<LtCsNoticeDTO> selectCsNotices(){
        return ltCsNoticeMapper.selectCsNotices();
    }


}
