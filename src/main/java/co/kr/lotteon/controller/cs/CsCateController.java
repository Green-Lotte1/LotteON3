package co.kr.lotteon.controller.cs;

import co.kr.lotteon.dto.LtCsCate1DTO;
import co.kr.lotteon.dto.LtCsCate2DTO;
import co.kr.lotteon.service.CsCateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RequestMapping("/cs")
@RestController
public class CsCateController {

    @Autowired
    private CsCateService csCateService;
    @GetMapping("/getCsCates")
    public Map<String, Object> getCsCates(){
        return csCateService.getCsCates();
    }

}
