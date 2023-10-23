package co.kr.lotteon.controller.my;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/my")
public class MypageController {

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

    @GetMapping(value = "/order")
    public String order(Model model) {

        return "/my/order";
    }

    @GetMapping(value = "/point")
    public String point(Model model) {

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
