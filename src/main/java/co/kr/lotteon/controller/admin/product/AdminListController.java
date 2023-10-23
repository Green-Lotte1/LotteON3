package co.kr.lotteon.controller.admin.product;

import co.kr.lotteon.dto.prodpage.ProdPageRequestDTO;
import co.kr.lotteon.dto.prodpage.ProdPageResponseDTO;
import co.kr.lotteon.service.LtProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminListController {

    @Autowired
    private LtProductService ltProductService;

    @GetMapping("/admin/product/list")
    public String ProductList(Model model, ProdPageRequestDTO prodPageRequestDTO){
        ProdPageResponseDTO prodPageResponseDTO = ltProductService.findLtProductEntities(prodPageRequestDTO);
        model.addAttribute(prodPageResponseDTO);

        return "/admin/product/list";
    }


}
