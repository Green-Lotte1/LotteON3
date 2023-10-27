package co.kr.lotteon.repository;

import co.kr.lotteon.entity.LtProductOrderItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LtProductOrderItemRepository extends JpaRepository<LtProductOrderItemEntity, Integer> {
    List<LtProductOrderItemEntity> findAllByLtProductOrderItemPK_OrdNo(int ordNo);

    @Query(value = "select i from lt_product_order_item i" +
            " JOIN FETCH i.ltProductEntity  " +
            " where  i.ordNo = :ordNo ",nativeQuery = true
    )
    List<LtProductOrderItemEntity> findAllByLtProductOrderItemPK_OrdNo1(@Param("ordNo") int ordNo);

}
