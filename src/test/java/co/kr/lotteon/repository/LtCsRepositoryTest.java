package co.kr.lotteon.repository;

import co.kr.lotteon.dto.LtCsNoticeDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;


@SpringBootTest
class LtCsRepositoryTest {

    @Autowired
    private LtCsNoticeMapper ltCsNoticeMapper;



    @Test
    public void test1(){

        List<LtCsNoticeDTO> result = ltCsNoticeMapper.selectCsNotices();

        System.out.println("test1.... : " + result);
        for(LtCsNoticeDTO dto : result){
            System.out.println("test2.... : " + dto);
        }

        System.out.println("test3....");
    }

}