package co.kr.staralba.web;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Controller
public class IndexController {
    @GetMapping("/")
    public String index(){
        return "index_login";
    }
    @GetMapping("main")
    public String main(){
        return "index";
    }
}
