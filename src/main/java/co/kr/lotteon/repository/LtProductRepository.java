package co.kr.lotteon.repository;


import co.kr.lotteon.entity.LtProductEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LtProductRepository extends JpaRepository<LtProductEntity, Integer> {

    List<LtProductEntity> findAll();

    public Page<LtProductEntity> findAll(Pageable pageable);

    /*public Page<LtProductEntity> findLtProductEntitiesByProdCate1(int prodCate1, Pageable pageable);*/

/*    public List<LtProductEntity> findLtProductEntityByProdName(String prodName);
    public List<LtProductEntity> findLtProductEntityByProdNo(String prodNo);
    public List<LtProductEntity> findLtProductEntityBy(String prodName);
    public List<LtProductEntity> findLtProductEntityByprodName(String prodName);*/


}
