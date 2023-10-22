package co.kr.lotteon.entity;

import co.kr.lotteon.dto.LtProductCartDTO;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "lt_product_cart")
public class LtProductCartEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cartNo;
    private String  uid;
    private int prodNo;
    private int count;
    private int price;
    private int discount;
    private int point;
    private int delivery;
    private int total;
    @CreationTimestamp
    private String rDate;

    private String prodName;
    private String descript;
    private String thumb1;

    public LtProductCartDTO toDTO() {
        return LtProductCartDTO.builder()
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
