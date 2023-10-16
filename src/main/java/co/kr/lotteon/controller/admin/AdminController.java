package co.kr.lotteon.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

//메인페이지
@Controller
public class AdminController {
    @GetMapping("/admin/index")
    public String index(){
        return "/admin/index";
    }

}
