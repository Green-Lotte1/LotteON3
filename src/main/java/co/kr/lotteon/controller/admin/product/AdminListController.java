package co.kr.lotteon.controller.admin.product;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminListController {

    @GetMapping("/admin/product/list")
    public String ProductRegister(){
        return "/admin/product/list";
    }


}
