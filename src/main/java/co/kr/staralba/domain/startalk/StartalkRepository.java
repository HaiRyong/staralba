package co.kr.staralba.domain.startalk;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StartalkRepository extends JpaRepository<Startalk, Long>{
   // Page<Startalk> findAll(Pageable pageable);
}
