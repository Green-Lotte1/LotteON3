package co.kr.lotteon.repository;

import co.kr.lotteon.entity.LtCsNoticeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LtCsRepository extends JpaRepository<LtCsNoticeEntity, Integer> {



    @Query("SELECT a FROM LtCsNoticeEntity a JOIN LtCsCate2Entity b ON a.cate1 = b.cate1 AND a.cate2 = b.cate2")
    public List<LtCsNoticeEntity> findNoticesWithCategory();


}


