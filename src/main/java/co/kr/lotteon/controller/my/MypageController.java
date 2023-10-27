package co.kr.lotteon.controller.my;

import co.kr.lotteon.dto.LtCsQnaDTO;
import co.kr.lotteon.dto.mypage.MyPageRequestDTO;
import co.kr.lotteon.dto.mypage.MyPageResponseDTO;
import co.kr.lotteon.security.MyUserDetails;
import co.kr.lotteon.service.LtCsService;
import co.kr.lotteon.service.MyService;
import lombok.Builder;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Log4j2
@Controller
@RequestMapping("/my")
public class MypageController {

    @Autowired
    private MyService myService;

    @Autowired
    private LtCsService ltCsService;

    @GetMapping(value = "/home")
    public String myIndex(Model model) {

        return "/my/home";
    }

    @GetMapping(value = "/info")
    public String info(Model model) {

        return "/my/info";
    }

    @GetMapping(value = "/coupon")
    public String coupon(Model model) {

        return "/my/coupon";
    }

    @GetMapping(value = "/ordered")
    public String order(Model model, MyPageRequestDTO pageRequestDTO, @AuthenticationPrincipal MyUserDetails myUserDetails) {
        if(myUserDetails == null) return "redirect:/index";
        MyPageResponseDTO pageResponseDTO = myService.showOrder(pageRequestDTO, myUserDetails.getUser().getUid());
        model.addAttribute("pageResponseDTO", pageResponseDTO);
        return "/my/ordered";
    }

    @GetMapping(value = "/point")
    public String point(Model model, MyPageRequestDTO pageRequestDTO, @AuthenticationPrincipal MyUserDetails myUserDetails) {
        if(myUserDetails == null) return "redirect:/index";
        MyPageResponseDTO pageResponseDTO = myService.showPoint(pageRequestDTO, myUserDetails.getUser().getUid());
        model.addAttribute("pageResponseDTO", pageResponseDTO);
        return "/my/point";
    }

    @RequestMapping(value = "/qna")
    public String qna(Model model,
                      @AuthenticationPrincipal MyUserDetails myUserDetails,
                      @RequestParam(name="pg", defaultValue = "1")String pg
                      ) {
        if(myUserDetails == null) return "redirect:/index";

        String writer = myUserDetails.getUser().getUid();
        log.info("qna writer---------"+writer);
        log.info("qnaPg----------"+pg);

        //현재 페이지 번호
        int currentPage = ltCsService.getCurrentPage(pg);

        log.info("currentPage----------"+currentPage);

        //시작 인덱스
        int start = ltCsService.getStartNum(currentPage);

        //전체 게시물 갯수
        int total;
        total = Integer.parseInt((ltCsService.selectMyQnaTotal(writer)));
        log.info("qnaBoardTotal------"+total);

        List<LtCsQnaDTO> ltCsQnaDTO =  ltCsService.selectMyQnaBoard(writer,start);

        log.info("ltCsQnaDTO-------"+ltCsQnaDTO.toString());
        // 마지막 페이지 번호
        int lastPageNum = ltCsService.getLastPageNum(total);

        // 페이지 그룹 start, end 번호
        int[] result = ltCsService.getPageGroupNum(currentPage, lastPageNum);

        // 페이지 시작번호
        int pageStartNum = ltCsService.getPageStartNum(total, currentPage);

        model.addAttribute("ltCsQnaDTO",ltCsQnaDTO);
        model.addAttribute("currentPage",currentPage);
        model.addAttribute("lastPageNum",lastPageNum);
        model.addAttribute("pageGroupStart",result[0]);
        model.addAttribute("pageGroupEnd",result[1]);
        model.addAttribute("pageStartNum",pageStartNum+1);

        log.info(currentPage);
        log.info(lastPageNum);
        log.info("pageStartNum-----="+pageStartNum);


        return "/my/qna";
    }

    @GetMapping(value = "/review")
    public String review(Model model) {

        return "/my/review";
    }

}
