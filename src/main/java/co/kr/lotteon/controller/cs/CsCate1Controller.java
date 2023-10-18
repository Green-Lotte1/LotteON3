package co.kr.lotteon.controller.cs;

import co.kr.lotteon.dto.LtCsCate1DTO;
import co.kr.lotteon.service.LtCsService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Log4j2
@RestController
public class CsCate1Controller {

    @Autowired
    private LtCsService ltCsService;

    @GetMapping("/cs/cate1")
    @ResponseBody
    public List<LtCsCate1DTO> list(){

        List<LtCsCate1DTO> cate1list = ltCsService.selectCsCate1();

        log.info(cate1list);
        return cate1list;

    }

}
