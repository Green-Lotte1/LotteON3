package co.kr.lotteon.controller.cs;

import co.kr.lotteon.entity.LtCsNoticeEntity;
import co.kr.lotteon.service.LtCsNoticeService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@Log4j2
public class CsController {

    @Autowired
    private LtCsNoticeService ltCsNoticeService;

    @GetMapping("/cs/index")
    public String index(Model model){


        List<LtCsNoticeEntity> noticelist = ltCsNoticeService.selectnotices();
        model.addAttribute("noticelist",noticelist);

        log.info(noticelist.toString());

        return "/cs/index";
    }
}
