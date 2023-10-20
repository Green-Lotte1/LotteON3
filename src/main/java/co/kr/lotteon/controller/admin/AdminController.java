package co.kr.lotteon.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.info.BuildProperties;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

//메인페이지
@Controller
public class AdminController {

    @Autowired
    private BuildProperties buildProperties; // 빌드 정보를 갖는 객체 주입

    @GetMapping(value={"/admin/","/admin/index"})
    public String index(Model model){

        // build.gradle 파일 맨 밑에 빌드 정보를 가져오기 위해 buildInfo() 호출 해야됨
        String appName = buildProperties.getName(); // settings.gradle 파일에서 앱이름 가져옴
        String version = buildProperties.getVersion(); // build.gradle 파일에서 버전값 가져옴
        System.out.println("appName : " + appName);
        System.out.println("version : " + version);

        model.addAttribute("appInfo", appName+version);

        return "/admin/index";
    }

}