package co.kr.staralba.staralba.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
    @GetMapping("login")
    public String login(){
        return "staralba/index_login";
    }
}
