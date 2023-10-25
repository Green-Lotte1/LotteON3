package co.kr.lotteon.entity;

import co.kr.lotteon.dto.LtProductOrderItemDTO;
import jakarta.persistence.*;
import lombok.*;

import java.text.DecimalFormat;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "lt_product_order_item")
public class LtProductOrderItemEntity {

    @EmbeddedId
    LtProductOrderItemPK ltProductOrderItemPK;
    private int count;
    private int price;
    private int discount;
    private int point;
    private int delivery;
    private int total;

    public LtProductOrderItemDTO toDTO(){
        return LtProductOrderItemDTO.builder()
                .ordNo(ltProductOrderItemPK.getOrdNo())
                .prodNo(ltProductOrderItemPK.getProdNo())
                .count(count)
                .price(price)
                .discount(discount)
                .point(point)
                .delivery(delivery)
                .total(total)
        .build();
    }




}
