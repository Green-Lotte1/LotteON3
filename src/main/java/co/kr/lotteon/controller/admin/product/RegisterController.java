package co.kr.lotteon.controller.admin.product;

import co.kr.lotteon.dto.LtProductCate1DTO;
import co.kr.lotteon.service.LtAdminService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Log4j2
@Controller
public class RegisterController {

    @Autowired
    private LtAdminService ltAdminService;

    @GetMapping("/admin/product/register")
    public String ProductRegister(Model model){
        List<LtProductCate1DTO> pCate1List = ltAdminService.selectLtProductCate1s();
        log.info("pCate1List : " + pCate1List);

        model.addAttribute("pCate1List", pCate1List);
        return "/admin/product/register";
    }



}
