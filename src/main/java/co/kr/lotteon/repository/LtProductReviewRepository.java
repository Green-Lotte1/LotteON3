package co.kr.lotteon.repository;

import co.kr.lotteon.entity.LtMemberPointEntity;
import co.kr.lotteon.entity.LtProductEntity;
import co.kr.lotteon.entity.LtProductReviewEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LtProductReviewRepository extends JpaRepository<LtProductReviewEntity, Integer> {

    public Page<LtProductReviewEntity> findAllByUid(String uid, Pageable pageable);


    public Page<LtProductReviewEntity> findAllByLtProductEntity(LtProductEntity ltProductEntity, Pageable pageable);
}
