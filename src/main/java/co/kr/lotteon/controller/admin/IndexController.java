package co.kr.lotteon.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping("/admin/index")
    public String AdminIndex(){
        return "/admin/index";
    }
}
