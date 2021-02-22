package co.kr.staralba.service;

import co.kr.staralba.domain.Role;
import co.kr.staralba.domain.member.Member;
import co.kr.staralba.domain.member.MemberRepository;
import co.kr.staralba.web.dto.member.MemberDto;
import jdk.nashorn.internal.runtime.logging.Logger;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;

import javax.transaction.Transactional;
import java.util.*;

@Log4j2
@RequiredArgsConstructor
@Service
public class MemberService implements UserDetailsService {

    private final MemberRepository memberRepository;

    /**
     * 회원가입 시, 유효성 체크
     *
     * */
    public Map<String, String> validateHandling(Errors errors) {
        Map<String, String> validatorResult = new HashMap<>();
        for (FieldError error : errors.getFieldErrors()) {
            String validKeyName = String.format("valid_%s", error.getField());
            validatorResult.put(validKeyName, error.getDefaultMessage());
        }
        return validatorResult;
    }

    /**
     * 아이디 중복확인
     *
     * */
    public String idCheck(String userId) {
        log.info("---- check userId: "+memberRepository.findUserByUserId(userId)+"----");
        if (memberRepository.findUserByUserId(userId).isPresent()) {
            return "failed";
        } else {
            return "success";
        }
    }

    /**
     * 회원가입
     *
     * */
    @Transactional
    public Long join(MemberDto memberDto) {
        // 비밀번호 암호화
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        memberDto.setPassword(passwordEncoder.encode(memberDto.getPassword()));
        return memberRepository.save(memberDto.toEntity()).getId();
    }

    @Override
    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
        log.info("---- UserId: "+ userId +"----");
        log.info("---- findUserByUserId: "+ memberRepository.findUserByUserId(userId) +"----");
        Optional<Member> userEntityWrapper = memberRepository.findUserByUserId(userId);
        Member userEntity = userEntityWrapper.get();
        log.info("---- Member: "+ userEntity+"----");
        List<GrantedAuthority> authorities = new ArrayList<>();

        if (("admin").equals(userId)) {
            authorities.add(new SimpleGrantedAuthority(Role.ADMIN.getValue()));
        } else {
            authorities.add(new SimpleGrantedAuthority(Role.MEMBER.getValue()));
        }
        return new User(userEntity.getUserId(), userEntity.getPassword(), authorities);
    }
}
