package co.kr.staralba.domain.member;

import co.kr.staralba.domain.BaseTimeEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@Table(name = "member")
public class Member extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(length = 20, nullable = false)
    private String userId;

    @Column(length = 100, nullable = false)
    private String password;

    @Builder
    public Member(Long id, String userId, String password) {
        this.id = id;
        this.userId = userId;
        this.password = password;
    }
}
