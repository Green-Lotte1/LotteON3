package co.kr.lotteon.repository;


import co.kr.lotteon.entity.LtProductEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LtProductRepository extends JpaRepository<LtProductEntity, Integer> {

//    admin 상품 리스트, 조건 검색

    //전체 출력(isRemoved = 0 판매 중 상품)
    public Page<LtProductEntity> findAll(Pageable pageable);

    public Page<LtProductEntity> findAllByProdCate1AndProdCate2(int prodCate1, int prodCate2, Pageable pageable);

    //조건 검색(제품명, 제품코드, 제조사)
    public Page<LtProductEntity> findLtProductEntityByProdNameContains(String prodName, Pageable pageable);
    public Page<LtProductEntity> findLtProductEntityByProdNoContains(String prodNo, Pageable pageable);
    public Page<LtProductEntity> findLtProductEntityByCompanyContains(String company, Pageable pageable);


    //    index_prod_list
    // hit_prod
    public List<LtProductEntity> findTop8ByOrderByHitDesc();

    // recommend_prod
    public List<LtProductEntity> findTop8ByOrderByScoreDesc();

    // new_prod
    public List<LtProductEntity> findTop8ByOrderByRegDateDesc();

    // discount_prod
    public List<LtProductEntity> findTop8ByOrderByDiscountDesc();

    // Best_prod(sold)
    public  List<LtProductEntity> findTop5ByOrderBySoldDesc();

}
