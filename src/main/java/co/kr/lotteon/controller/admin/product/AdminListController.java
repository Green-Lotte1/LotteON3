package co.kr.lotteon.controller.admin.product;

import co.kr.lotteon.dto.prodpage.ProdPageRequestDTO;
import co.kr.lotteon.dto.prodpage.ProdPageResponseDTO;
import co.kr.lotteon.service.LtAdminService;
import co.kr.lotteon.service.LtProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.MergedAnnotations;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AdminListController {

    @Autowired
    private LtProductService ltProductService;

    @Autowired
    private LtAdminService ltAdminService;

    @GetMapping("/admin/product/list")
    public String ProductList(Model model, ProdPageRequestDTO prodPageRequestDTO){

        //상품 전체 조회
        ProdPageResponseDTO prodPageResponseDTO = ltProductService.search(prodPageRequestDTO);
        System.out.println("asdifjlowsej f: "+ prodPageResponseDTO);
        model.addAttribute(prodPageResponseDTO);


        //조건 검색


        return "/admin/product/list";
    }





}
