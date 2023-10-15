package co.kr.lotteon.repository;

import co.kr.lotteon.entity.LtCsNoticeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LtCsNoticeRepository extends JpaRepository<LtCsNoticeEntity, Integer> {
    List<LtCsNoticeEntity> findTop5ByOrderByNoticeNoAsc();


}
