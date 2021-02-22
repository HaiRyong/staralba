package co.kr.staralba.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Role {
    ADMIN("ROLE_ADMIN"),
    ENTERPRISE("ROLE_ENTERPRISE"),
    MEMBER("ROLE_MEMBER");

    private String value;
}