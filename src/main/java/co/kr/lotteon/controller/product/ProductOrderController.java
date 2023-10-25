package co.kr.lotteon.controller.product;

import co.kr.lotteon.dto.LtProductCartDTO;
import co.kr.lotteon.dto.order.OrderTotalDTO;
import co.kr.lotteon.service.ProductCartSerivce;
import co.kr.lotteon.service.ProductOrderService;
import co.kr.lotteon.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Log4j2
@Controller
@RequiredArgsConstructor
@RequestMapping("/product")
public class ProductOrderController {

    private final ProductService productService;
    private final ProductCartSerivce productCartSerivce;
    private final ProductOrderService productOrderService;


    @GetMapping("/order")
    public String order(){return "redirect:/index";}

    @PostMapping("/order")
    public String order(Model model, OrderTotalDTO orderTotalDTO, @RequestParam(name="chk") String[] chk){

        List<LtProductCartDTO> dtoList = productOrderService.showOrder(chk);
        model.addAttribute("dtoList", dtoList);
        model.addAttribute("orderTotal", orderTotalDTO);
        log.info("orderTotal : " + orderTotalDTO);

        return "/product/order";
    }
}
