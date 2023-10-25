package co.kr.lotteon.controller.product;

import co.kr.lotteon.dto.LtProductCartDTO;
import co.kr.lotteon.dto.LtProductDTO;
import co.kr.lotteon.dto.prodpage.ProdPageRequestDTO;
import co.kr.lotteon.dto.prodpage.ProdPageResponseDTO;
import co.kr.lotteon.security.MyUserDetails;
import co.kr.lotteon.service.LtProductService;
import co.kr.lotteon.service.ProductCartSerivce;
import co.kr.lotteon.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Log4j2
@Controller
@RequiredArgsConstructor
@RequestMapping("/product")
public class ProductController {

    private final LtProductService ltProductService;
    private final ProductService productService;
    private final ProductCartSerivce productCartSerivce;
    private final ModelMapper modelMapper;

    @GetMapping("/list")
    public String list(Model model, ProdPageRequestDTO pageRequestDTO) {

        ProdPageResponseDTO pageResponseDTO = productService.getProductListByCates(pageRequestDTO);
        if(pageResponseDTO.getTotal()/10 < pageRequestDTO.getPg()){
            //return "redirect:/article/list?success=100";
        }

        log.info("pageResponseDTO cate1 : " + pageResponseDTO.getCate1());
        log.info("pageResponseDTO cate2 : " + pageResponseDTO.getCate2());
        log.info("pageResponseDTO pg : " + pageResponseDTO.getPg());
        log.info("pageResponseDTO size : " + pageResponseDTO.getSize());
        log.info("pageResponseDTO total : " + pageResponseDTO.getTotal());
        log.info("pageResponseDTO start : " + pageResponseDTO.getStart());
        log.info("pageResponseDTO end : " + pageResponseDTO.getEnd());
        log.info("pageResponseDTO prev : " + pageResponseDTO.isPrev());
        log.info("pageResponseDTO next : " + pageResponseDTO.isNext());

        model.addAttribute("pageResponseDTO", pageResponseDTO);
        return "/product/list";
    }

    @GetMapping("/view")
    public String view(@RequestParam(value = "prodNo")int proNo, Model model) {

        LtProductDTO dto = ltProductService.getProdDto(proNo);
        model.addAttribute("prod",dto);
        return "/product/view";

    }

    @GetMapping("/search")
    public String search() {
        return "/product/search";
    }

}

