package co.kr.staralba.service;

import co.kr.staralba.domain.enterprise.EnterpriseRepository;
import co.kr.staralba.domain.Role;
import co.kr.staralba.domain.enterprise.Enterprise;
import co.kr.staralba.domain.enterprise.EnterpriseRepository;
import co.kr.staralba.domain.member.Member;
import co.kr.staralba.domain.member.MemberRepository;
import co.kr.staralba.web.dto.enterprise.EnterpriseDto;
import co.kr.staralba.web.dto.member.MemberDto;
import lombok.RequiredArgsConstructor;
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

@RequiredArgsConstructor
@Service
public class EnterpriseService implements UserDetailsService {

    private final EnterpriseRepository enterpriseRepository;

    // 회원가입 시, 유효성 체크
    public Map<String, String> validateHandling(Errors errors) {
        Map<String, String> validatorResult = new HashMap<>();

        for (FieldError error : errors.getFieldErrors()) {
            String validKeyName = String.format("valid_%s", error.getField());
            validatorResult.put(validKeyName, error.getDefaultMessage());
        }
        return validatorResult;
    }

    //아이디 중복 확인
    public String idCheck(String userId) {
        System.out.println("---- check userId: "+enterpriseRepository.findUserByUserId(userId)+"----");
        if (enterpriseRepository.findUserByUserId(userId).isPresent()) {
            return "failed";
        } else {
            return "success";
        }
    }

    @Transactional
    public Long join(EnterpriseDto enterpriseDto) {
        // 비밀번호 암호화
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        enterpriseDto.setPassword(passwordEncoder.encode(enterpriseDto.getPassword()));
        return enterpriseRepository.save(enterpriseDto.toEntity()).getId();
    }

    @Override
    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
        System.out.println("---- UserId: "+ userId +"----");
        System.out.println("---- findUserByUserId: "+ enterpriseRepository.findUserByUserId(userId) +"----");
        Optional<Enterprise> userEntityWrapper = enterpriseRepository.findUserByUserId(userId);
        Enterprise userEntity = userEntityWrapper.get();
        System.out.println("---- Member: "+ userEntity+"----");
        List<GrantedAuthority> authorities = new ArrayList<>();

        if (("admin").equals(userId)) {
            authorities.add(new SimpleGrantedAuthority(Role.ADMIN.getValue()));
        } else {
            authorities.add(new SimpleGrantedAuthority(Role.MEMBER.getValue()));
        }

        return new User(userEntity.getUserId(), userEntity.getPassword(), authorities);
    }

}
