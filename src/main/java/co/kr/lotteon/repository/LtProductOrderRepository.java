package co.kr.lotteon.repository;

import co.kr.lotteon.entity.LtProductOrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LtProductOrderRepository extends JpaRepository<LtProductOrderEntity, Integer> {
}