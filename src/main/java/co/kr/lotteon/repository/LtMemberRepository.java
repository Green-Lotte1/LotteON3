package co.kr.lotteon.repository;

import co.kr.lotteon.entity.LtMemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LtMemberRepository extends JpaRepository<LtMemberEntity, String> {

    int countByUid(String uid);
}
