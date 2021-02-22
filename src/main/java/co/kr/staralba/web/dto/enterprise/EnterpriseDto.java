package co.kr.staralba.web.dto.enterprise;

import co.kr.staralba.domain.enterprise.Enterprise;
import co.kr.staralba.domain.member.Member;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Getter
@Setter
@ToString
@NoArgsConstructor

public class EnterpriseDto {
    private Long id;

    @NotBlank(message = "아이디는 필수 입력 값입니다.")
    private String userId;

    @NotBlank(message = "비밀번호는 필수 입력 값입니다.")
    @Pattern(regexp="(?=.*[0-9])(?=.*[a-zA-Z])(?=.*\\W)(?=\\S+$).{12}",
            message = "비밀번호는 영문 대,소문자와 숫자, 특수기호가 적어도 1개 이상씩 포함된 12자의 비밀번호여야 합니다.")
    private String password;


    @Builder
    public EnterpriseDto(Long id, String userId, String password) {
        this.id = id;
        this.userId = userId;
        this.password = password;
    }
    public Enterprise toEntity() {
        return Enterprise.builder()
                .userId(userId)
                .password(password)
                .build();
    }
}
