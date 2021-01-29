package co.kr.staralba.staralba.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StarTalkController {
    @GetMapping("startalk")
    public String startalk(){
        return "staralba/startalk_list";
    }
}
