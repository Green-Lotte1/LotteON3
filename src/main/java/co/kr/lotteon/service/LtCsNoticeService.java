package co.kr.lotteon.service;

import co.kr.lotteon.entity.LtCsNoticeEntity;
import co.kr.lotteon.repository.LtCsNoticeRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log4j2
public class LtCsNoticeService {

    @Autowired
    private LtCsNoticeRepository ltCsNoticeRepository;

    public List<LtCsNoticeEntity> selectnotices(){
        return ltCsNoticeRepository.findTop5ByOrderByNoticeNoAsc();
    }
}
