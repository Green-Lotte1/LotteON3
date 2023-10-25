package co.kr.lotteon.repository;

import co.kr.lotteon.entity.LtProductOrderItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LtProductOrderItemRepository extends JpaRepository<LtProductOrderItemEntity, Integer> {
}
