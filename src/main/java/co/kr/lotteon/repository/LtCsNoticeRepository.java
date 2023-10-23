package co.kr.lotteon.repository;

import co.kr.lotteon.entity.LtCsNoticeEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LtCsNoticeRepository extends JpaRepository<LtCsNoticeEntity, Integer> {


/*
    @Query("SELECT a FROM LtCsNoticeEntity a JOIN LtCsCate2Entity b ON a.cate1 = b.cate1 AND a.cate2 = b.cate2")
    public List<LtCsNoticeEntity> findNoticesWithCategory();
*/
    public Page<LtCsNoticeEntity> findAll(Pageable pageable);

    public Page<LtCsNoticeEntity> findAllByCate1(int cate1, Pageable pageable);

    /*
    @Query("SELECT a, b.c1Name, c.c2Name FROM LtCsNoticeEntity a " +
            "JOIN a.ltCsCate1Entity b " +
            "JOIN a.ltCsCate2Entity c " +
            "WHERE a.ltCsCate2Entity.cate2 = :cate2")
    List<Object[]> findNoticeAndCate1AndCate2ByCate2(@Param("cate1") int cate1);
    @Query("SELECT a, b.c1Name, c.c2Name FROM LtCsNoticeEntity a " +
            "JOIN a.ltCsCate1Entity b " +
            "JOIN a.ltCsCate2Entity c " +
            " ORDER BY a.noticeNo")
    List<Object[]> findAllWithC1NameAndC2Name();
*/

}


