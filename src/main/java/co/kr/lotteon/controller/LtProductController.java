package co.kr.lotteon.controller;

import co.kr.lotteon.dto.LtProductDTO;
import co.kr.lotteon.dto.prodpage.ProdPageRequestDTO;
import co.kr.lotteon.dto.prodpage.ProdPageResponseDTO;
import co.kr.lotteon.service.LtProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Log4j2
@Controller
@RequiredArgsConstructor
@RequestMapping("/product")
public class LtProductController {

    private final LtProductService ltProductService;
    private final ModelMapper modelMapper;

    @GetMapping("/list")
    public String list(Model model, ProdPageRequestDTO pageRequestDTO) {

        List<LtProductDTO> productlist = ltProductService.selectProducts();
        model.addAttribute("productlist",productlist);
        return "/product/list";
    }

    @GetMapping("/view")
    public String view(@RequestParam(value = "prodNo")int proNo, Model model) {

        LtProductDTO dto = ltProductService.getProdDto(proNo);
        model.addAttribute("prod",dto);
        return "/product/view";

    }

    @GetMapping("/complete")
    public String complete() {
        return "/product/complete";
    }


    @GetMapping("/order")
    public String order() {
        return "/product/order";
    }

    @GetMapping("/search")
    public String search() {
        return "/product/search";
    }

    @GetMapping("/cart")
    public String cart() {
        return "/product/cart";
    }

}

