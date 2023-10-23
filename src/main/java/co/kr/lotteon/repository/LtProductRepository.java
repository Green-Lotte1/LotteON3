package co.kr.lotteon.repository;


import co.kr.lotteon.entity.LtCsNoticeEntity;
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

    public Page<LtProductEntity> findAllByProdCate1AndProdCate2(int prodCate1, int prodCate2, Pageable pageable);

    /*public Page<LtProductEntity> findLtProductEntitiesByProdCate1(int prodCate1, Pageable pageable);*/

/*    public List<LtProductEntity> findLtProductEntityByProdName(String prodName);
    public List<LtProductEntity> findLtProductEntityByProdNo(String prodNo);
    public List<LtProductEntity> findLtProductEntityBy(String prodName);
    public List<LtProductEntity> findLtProductEntityByprodName(String prodName);*/

//    index_prod_list
    // hit_prod
    public List<LtProductEntity> findTop8ByOrderByHitDesc();

    //    // recommend_prod
//    public List<LtProductEntity> findTop8ByOrderBySoldDesc();

    // new_prod
//    public List<LtProductEntity> findTop8ByOrderByRDateDesc();

    // discount_prod
    public List<LtProductEntity> findTop8ByOrderByDiscountDesc();

}
