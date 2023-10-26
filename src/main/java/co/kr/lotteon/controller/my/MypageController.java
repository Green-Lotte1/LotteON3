package co.kr.lotteon.controller.my;

import co.kr.lotteon.dto.mypage.MyPageRequestDTO;
import co.kr.lotteon.dto.mypage.MyPageResponseDTO;
import co.kr.lotteon.security.MyUserDetails;
import co.kr.lotteon.service.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/my")
public class MypageController {

    @Autowired
    private MyService myService;

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

    @GetMapping(value = "/qna")
    public String qna(Model model) {

        return "/my/qna";
    }

    @GetMapping(value = "/review")
    public String review(Model model) {

        return "/my/review";
    }

}
