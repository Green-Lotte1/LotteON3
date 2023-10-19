package co.kr.lotteon.repository;


import co.kr.lotteon.entity.LtProductEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LtProductRepository extends JpaRepository<LtProductEntity, Integer> {

}
