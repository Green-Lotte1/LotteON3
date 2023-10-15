package co.kr.lotteon.controller.admin.product;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegisterController {

    @GetMapping("/admin/product/register")
    public String ProductRegister(){
        return "/admin/product/register";
    }


}
