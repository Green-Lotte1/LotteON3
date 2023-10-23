package co.kr.lotteon.controller.admin.cs;

import co.kr.lotteon.dto.LtCsNoticeDTO;
import co.kr.lotteon.dto.cspage.CsPageRequestDTO;
import co.kr.lotteon.dto.cspage.CsPageResponseDTO;
import co.kr.lotteon.service.AdminCsService;
import co.kr.lotteon.service.LtCsService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Log4j2
@Controller
public class ArticleController {


    @Autowired
    private LtCsService csService;
    @Autowired
    private AdminCsService adminCsService;

    @GetMapping("/admin/cs/notice/write")
    public String write(){
        return "/admin/cs/notice/write";
    }

    @PostMapping("/admin/cs/notice/write")
    public String write(LtCsNoticeDTO dto, HttpServletRequest req){

        dto.setRegip(req.getRemoteAddr());
        log.info("회원가입정보 : " + dto.toString());

        adminCsService.saveNotice(dto);
        return "redirect:/admin/cs/notice/list";
    }

    @GetMapping("/admin/cs/notice/modify")
    public String modify(){
        return "/admin/cs/notice/modify";
    }

    @GetMapping("/admin/cs/notice/view")
    public String view(){
        return "/admin/cs/notice/view";
    }

    @GetMapping(value = {"/admin/cs/notice/list", "/admin/cs/notice/"})
    public String list(Model model, CsPageRequestDTO pageRequestDTO){
        //List<LtCsNoticeDTO> noticeList = adminCsService.noticeList();
        // model.addAttribute("noticeList", noticeList);
        CsPageResponseDTO pageResponseDTO = adminCsService.noticeList(pageRequestDTO);

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
        return "/admin/cs/notice/list";
    }
}
