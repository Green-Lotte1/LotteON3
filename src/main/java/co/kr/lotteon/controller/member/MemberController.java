package co.kr.lotteon.controller.member;

import co.kr.lotteon.dto.LtMemberDTO;
import co.kr.lotteon.service.LtMemberService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
@Log4j2
@Controller
public class MemberController {


    @Autowired
    private LtMemberService ltMemberService;

    @GetMapping("/member/login")
    public String login(){
        return "/member/login";
    }

    @GetMapping("/member/register")
    public String register(){
        return "/member/register";
    }
    @PostMapping("/member/register")
    public String register(LtMemberDTO dto, HttpServletRequest req){

        dto.setRegIp(req.getRemoteAddr());
        log.info("회원가입정보 : " + dto.toString());


        ltMemberService.save(dto);
        return "redirect:/member/login";
    }

}
