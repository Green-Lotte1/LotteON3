package co.kr.lotteon.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "lt_product_cate2")
public class LtProductCate2Entity {
    @Id
    private int cate1;
    @Id
    private int cate2;
    private String c2Name;


}
