package co.kr.lotteon.controller.cs;

import co.kr.lotteon.dto.LtCsNoticeDTO;
import co.kr.lotteon.service.LtCsService;
import co.kr.lotteon.dto.LtCsQnaDTO;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;
import java.util.List;

@Controller
@Log4j2
public class CsController {

/*    @Autowired
    private BuildProperties buildProperties;*/

    @Autowired
    private LtCsService ltCsService;

    @GetMapping("/cs/index")
    public String index(Model model){

/*        // build.gradle 파일 맨 밑에 빌드 정보를 가져오기 위해 buildInfo() 호출 해야됨
        String appName = buildProperties.getName(); // settings.gradle 파일에서 앱이름 가져옴
        String version = buildProperties.getVersion(); // build.gradle 파일에서 버전값 가져옴


        System.out.println("appName : " + appName);
        System.out.println("version : " + version);

        model.addAttribute("appInfo", appName+version);*/

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
    @RequestMapping("/cs/notice/list")
    public String selectCsNoticeList(@RequestParam(name="pg", defaultValue = "1")String pg,
                                     @RequestParam(name= "cate1" ,required = false) String cate1,
                                     Model model){

        log.info(pg);
        log.info("cate1-----"+cate1);


        //현재 페이지 번호
        int currentPage = ltCsService.getCurrentPage(pg);

        log.info("currentPage----------"+currentPage);

        //시작 인덱스
        int start = ltCsService.getStartNum(currentPage);

        //전체 게시물 갯수
        int total;
        List<LtCsNoticeDTO> ltCsNoticeDTOS;

        if(cate1 == null || cate1.isEmpty()){
            log.info("here1");
            total = ltCsService.selectCsNoticeTotal();
            ltCsNoticeDTOS = ltCsService.selectCsNoticeListAll(start);
        } else {
            log.info("here2");
            log.info("here2 cate1------"+cate1);
            total = ltCsService.selectCsNoticeTotalCate(Integer.parseInt(cate1));

            log.info("here2 total : "+total);


            ltCsNoticeDTOS = ltCsService.selectCsNoticeListCate(Integer.parseInt(cate1), start);


        }


        // 마지막 페이지 번호
        int lastPageNum = ltCsService.getLastPageNum(total);

        // 페이지 그룹 start, end 번호
        int[] result = ltCsService.getPageGroupNum(currentPage, lastPageNum);

        // 페이지 시작번호
        int pageStartNum = ltCsService.getPageStartNum(total, currentPage);


        model.addAttribute("ltCsNoticeDTOS",ltCsNoticeDTOS);
        model.addAttribute("currentPage",currentPage);
        model.addAttribute("lastPageNum",lastPageNum);
        model.addAttribute("pageGroupStart",result[0]);
        model.addAttribute("pageGroupEnd",result[1]);
        model.addAttribute("pageStartNum",pageStartNum+1);
        model.addAttribute("cate1",cate1);
        log.info(currentPage);
        log.info(lastPageNum);
        log.info("cate1last----------------"+cate1);


        return "/cs/notice/list";
    }

    @RequestMapping("/cs/qna/list")
    public String selectCsQnaListAll(@RequestParam(name="pg", defaultValue = "1")String pg, Model model){

        log.info(pg);

        //현재 페이지 번호
        int currentPage = ltCsService.getCurrentPage(pg);

        log.info("currentPage----------"+currentPage);
        //전체 게시물 갯수
        int total = ltCsService.selectCsQnaTotal();

        // 마지막 페이지 번호
        int lastPageNum = ltCsService.getLastPageNum(total);

        // 페이지 그룹 start, end 번호
        int[] result = ltCsService.getPageGroupNum(currentPage, lastPageNum);

        // 페이지 시작번호
        int pageStartNum = ltCsService.getPageStartNum(total, currentPage);

        //시작 인덱스
        int start = ltCsService.getStartNum(currentPage);


        List<LtCsQnaDTO> selectCsQnaListAll = ltCsService.selectCsQnaListAll(start);

        model.addAttribute("qnaListAll",selectCsQnaListAll);
        model.addAttribute("currentPage",currentPage);
        model.addAttribute("lastPageNum",lastPageNum);
        model.addAttribute("pageGroupStart",result[0]);
        model.addAttribute("pageGroupEnd",result[1]);
        model.addAttribute("pageStartNum",pageStartNum+1);
        log.info("QnaListAll------------"+selectCsQnaListAll);
        log.info(currentPage);
        log.info(lastPageNum);


        return "/cs/qna/list";
    }

    @GetMapping("/cs/notice/view")
    public String selectCsNoticeView(int noticeNo, Model model){
        LtCsNoticeDTO notcieBoard = ltCsService.selectCSNoticeView(noticeNo);
        model.addAttribute("notcieBoard",notcieBoard);
        log.info("noticeNo------"+noticeNo);
        log.info("notcieBoard----------"+notcieBoard.toString());
        return "/cs/notice/view";
    }

    @GetMapping("/cs/qna/view")
    public String selectCsQnaView(int qnaNo, Model model){
        LtCsQnaDTO qnaBoard = ltCsService.selectCsQnaView(qnaNo);
        model.addAttribute("qnaBoard",qnaBoard);
        log.info("qnaNo------"+qnaNo);
        log.info("qnaBoard----------"+qnaBoard.toString());
        return "/cs/qna/view";
    }

}