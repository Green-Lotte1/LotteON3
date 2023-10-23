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

    public Page<LtProductEntity> findAll(Pageable pageable);

    public Page<LtProductEntity> findAllByProdCate1AndProdCate2(int prodCate1, int prodCate2, Pageable pageable);
    public List<LtProductEntity> findLtProductEntityByProdName(String prodName, Pageable pageable);
    public List<LtProductEntity> findLtProductEntityByProdNo(String prodNo, Pageable pageable);
    public List<LtProductEntity> findLtProductEntityByCompany(String company, Pageable pageable);
    public List<LtProductEntity> findLtProductEntityBySeller(String seller, Pageable pageable);



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
