package co.kr.lotteon.repository;

import co.kr.lotteon.entity.LtMemberEntity;
import co.kr.lotteon.entity.LtMemberPointEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LtMemberPointRepository extends JpaRepository<LtMemberPointEntity, Integer> {

    
}
