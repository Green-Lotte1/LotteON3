package co.kr.lotteon.dto;

import co.kr.lotteon.entity.LtProductCartEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LtProductCartDTO {

    private int cartNo;
    private String  uid;
    private int prodNo;
    private int count;
    private int price;
    private int discount;
    private int point;
    private int delivery;
    private int total;
    private String rDate;

    private String prodName;
    private String descript;
    private String thumb1;

    public LtProductCartEntity toEntity() {
        return LtProductCartEntity.builder()
                .cartNo(cartNo)
                .uid(uid)
                .prodNo(prodNo)
                .count(count)
                .price(price)
                .discount(discount)
                .point(point)
                .delivery(delivery)
                .total(total)
                .rDate(rDate)
                .prodName(prodName)
                .descript(descript)
                .thumb1(thumb1)
                .build();
    }


}
