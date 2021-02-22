package co.kr.staralba.domain.enterprise;


import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EnterpriseRepository extends JpaRepository<Enterprise, Long> {
    Optional<Enterprise> findUserByUserId(String userId);
}
