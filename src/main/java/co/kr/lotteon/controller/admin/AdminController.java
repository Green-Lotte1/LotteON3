package co.kr.lotteon.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.info.BuildProperties;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

//메인페이지
@Controller
public class AdminController {

    @GetMapping(value={"/admin/","/admin/index"})
    public String index(){
        return "/admin/index";
    }

}