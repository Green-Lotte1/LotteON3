package co.kr.lotteon.repository;


import co.kr.lotteon.entity.LtProductEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LtProductRepository extends JpaRepository<LtProductEntity, Integer> {

//    public Page<LtProductEntity> ;

}
