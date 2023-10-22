package co.kr.lotteon.entity;

import jakarta.persistence.*;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int revNo;
    private int prodNo;
    private String content;
    private String uid;
    private int rating;
    private String regIp;
    private String rDate;

}
