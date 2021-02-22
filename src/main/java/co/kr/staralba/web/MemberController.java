package co.kr.staralba.web;

import co.kr.staralba.service.MemberService;
import co.kr.staralba.web.dto.member.MemberDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.Map;

@RequiredArgsConstructor
@Controller
public class MemberController {
    private final MemberService memberService;

    // 회원가입 페이지
    @GetMapping("/user/signup")
    public String dispSignup(MemberDto memberDto) {
        return "signup";
    }

    //일반 회원가입
    @GetMapping("/user/signupForm")
    public String signupForm() {
        return "signup_form1";
    }


    //아이디 중복 체크
    @GetMapping("/user/idCheck")
    @ResponseBody
    public String id_check(String id) {
        System.out.println(id);
        String str = memberService.idCheck(id);
        return str;
    }

    // 회원가입 처리
    @PostMapping("/user/signup")
    public String execSignup(@Valid MemberDto memberDto, Errors errors, Model model) {
        if (errors.hasErrors()) {
            // 회원가입 실패시, 입력 데이터를 유지
            model.addAttribute("memberDto", memberDto);

            // 유효성 통과 못한 필드와 메시지를 핸들링
            Map<String, String> validatorResult = memberService.validateHandling(errors);
            for (String key : validatorResult.keySet()) {
                model.addAttribute(key, validatorResult.get(key));
            }
            return "signup_form1";
        }
        System.out.println("---- add userId: "+memberDto+"----");
        memberService.join(memberDto);
        return "redirect:/user/login";
    }

    // 로그인 페이지
    @GetMapping("/user/login")
    public String dispLogin() {
        return "signin";
    }


    // 로그아웃 결과 페이지
    @GetMapping("/user/logout")
    public String dispLogout() {
        return "logout";
    }
    // 접근 거부 페이지
    @GetMapping("/user/denied")
    public String dispDenied() {
        return "/denied";
    }

    // 내 정보 페이지
    @GetMapping("/user/info")
    public String dispMyInfo() {
        return "/myinfo";
    }

    // 어드민 페이지
    @GetMapping("/admin")
    public String dispAdmin() {
        return "/admin";
    }
}
