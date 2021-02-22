package co.kr.staralba.staralba.web;

import co.kr.staralba.service.EnterpriseService;
import co.kr.staralba.service.MemberService;
import co.kr.staralba.web.dto.enterprise.EnterpriseDto;
import co.kr.staralba.web.dto.member.MemberDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.Map;

@RequiredArgsConstructor
@Controller
public class EnterpriseController {
    private final EnterpriseService enterpriseService;

    //기업용 회원가입
    @GetMapping("/enterprise/signup")
    public String enterprise_signupForm() {
        return "signup_form2";
    }

    //아이디 중복 체크
    @GetMapping("/enterprise/idCheck")
    @ResponseBody
    public String id_check(String id) {
        System.out.println(id);
        String str = enterpriseService.idCheck(id);
        return str;
    }

    // 회원가입 처리
    @PostMapping("/enterprise/signup")
    public String execSignup(@Valid EnterpriseDto enterpriseDto, Errors errors, Model model) {
        if (errors.hasErrors()) {
            // 회원가입 실패시, 입력 데이터를 유지
            model.addAttribute("enterpriseDto", enterpriseDto);

            // 유효성 통과 못한 필드와 메시지를 핸들링
            Map<String, String> validatorResult = enterpriseService.validateHandling(errors);
            for (String key : validatorResult.keySet()) {
                model.addAttribute(key, validatorResult.get(key));
            }
            return "signup_form2";
        }
        System.out.println("---- add userId: "+enterpriseDto+"----");
        enterpriseService.join(enterpriseDto);
        return "redirect:/enterprise/login";
    }

    // 로그인 페이지
    @GetMapping("/enterprise/login")
    public String enterpriseLogin() {
        return "/signin";
    }

    // 로그인 결과 페이지
    /*@GetMapping("/user/login/result")
    public String dispLoginResult() {
        return "/loginSuccess";
    }*/

    // 로그아웃 결과 페이지
    @GetMapping("/enterprise/logout")
    public String enterpriseLogout() {
        return "logout";
    }

    // 접근 거부 페이지
    @GetMapping("/enterprise/denied")
    public String enterpriseDenied() {
        return "/denied";
    }

    // 내 정보 페이지
    @GetMapping("/enterprise/info")
    public String enterpriseMyInfo() {
        return "/myinfo";
    }

    // 어드민 페이지
    /*@GetMapping("/admin")
    public String admin() {
        return "/admin";
    }*/
}
