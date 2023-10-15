package co.kr.lotteon.controller.product;

import co.kr.lotteon.repository.LtProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Log4j2
@RequiredArgsConstructor
@Controller
public class ListController {

    private final LtProductRepository ltProductRepository;

    @GetMapping("/product/list")
    public String list() {
        return "/product/list";
    }

}
