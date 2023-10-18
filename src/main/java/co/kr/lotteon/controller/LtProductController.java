package co.kr.lotteon.controller;

import co.kr.lotteon.dto.LtProductDTO;
import co.kr.lotteon.service.LtProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Log4j2
@Controller
@RequiredArgsConstructor
@RequestMapping("/product")
public class LtProductController {

    private final LtProductService ltProductService;

    @GetMapping("/view/{prodNo}")
    public String view(@RequestParam(value = "prodNo") Model model, int prodNo) {

        LtProductDTO dto = ltProductService.getProdDto(prodNo);

        model.addAttribute("prodView", dto);

        return "/product/view";

    }

    @GetMapping("/complete")
    public String complete() {
        return "/product/complete";
    }

//todo    프로덕트 리스트 페이지 출력 테스트 완료 - 1018_11:23
    @GetMapping("/list")
    public String list(Model model) {

        List<LtProductDTO> productlist = ltProductService.selectProducts();
        model.addAttribute("productlist",productlist);

        return "/product/list";
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

