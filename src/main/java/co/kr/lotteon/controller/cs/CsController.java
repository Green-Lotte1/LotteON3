package co.kr.lotteon.controller.cs;

import co.kr.lotteon.dto.LtCsNoticeDTO;
import co.kr.lotteon.dto.LtCsQnaDTO;
import co.kr.lotteon.service.LtCsService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.info.BuildProperties;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDateTime;
import java.util.List;

@Controller
@Log4j2
public class CsController {

    @Autowired
    private BuildProperties buildProperties;

    @Autowired
    private LtCsService ltCsService;

    @GetMapping("/cs/index")
    public String index(Model model){

        // build.gradle 파일 맨 밑에 빌드 정보를 가져오기 위해 buildInfo() 호출 해야됨
        String appName = buildProperties.getName(); // settings.gradle 파일에서 앱이름 가져옴
        String version = buildProperties.getVersion(); // build.gradle 파일에서 버전값 가져옴


        System.out.println("appName : " + appName);
        System.out.println("version : " + version);

        model.addAttribute("appInfo", appName+version);

        List<LtCsNoticeDTO> noticelist = ltCsService.selectCsNotices();
        model.addAttribute("noticelist",noticelist);


        List<LtCsQnaDTO> qnalist = ltCsService.selectCsQna();
        model.addAttribute("qnalist",qnalist);

        log.info(noticelist.toString());
        log.info(qnalist.toString());

        return "/cs/index";
    }
    @GetMapping("/cs/qna/write")
    public String writeView(){
        return "/cs/qna/write";
    }

    @PostMapping("/cs/qna/write")
    public String write(HttpServletRequest request, LtCsQnaDTO dto){

        dto.setRegip(request.getRemoteAddr());
        dto.setRdate(LocalDateTime.now());
        ltCsService.insertQnaWrite(dto);
        return "redirect:/cs/index";

    }
    @GetMapping("/cs/notice/list")
    public String noticeListAll(Model model){
        List<LtCsNoticeDTO> noticeListAll = ltCsService.selectCsNoticeAll();
        model.addAttribute("noticeListAll",noticeListAll);
        log.info("noticelistALl------------"+noticeListAll);

        return "/cs/notice/list";
    }
}