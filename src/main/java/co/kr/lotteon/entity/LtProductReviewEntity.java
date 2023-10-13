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
@Table(name = "lt_product_review")
public class LtProductReviewEntity {
    @Id
    private int revNo;
    private int prodNo;
    private String content;
    private String uid;
    private int rating;
    private String regIp;
    private String rDate;

}
