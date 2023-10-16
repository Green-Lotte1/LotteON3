package co.kr.lotteon.controller.admin.cs;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ArticleController {

    @GetMapping("/admin/cs/notice/write")
    public String write(){
        return "/admin/cs/notice/write";
    }

    @GetMapping("/admin/cs/notice/modify")
    public String modify(){
        return "/admin/cs/notice/modify";
    }

    @GetMapping("/admin/cs/notice/view")
    public String view(){
        return "/admin/cs/notice/view";
    }

    @GetMapping("/admin/cs/notice/list")
    public String list(){
        return "/admin/cs/notice/list";
    }
}
