package co.kr.lotteon.entity;

import co.kr.lotteon.dto.LtProductReviewDTO;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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
    private int ordNo;
    //private int prodNo;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="prodNo", insertable=false, updatable=false)
    private LtProductEntity ltProductEntity;

    private String content;
    private String uid;
    private int rating;
    private String regIp;
    @CreationTimestamp
    private LocalDateTime rDate;

    public LtProductReviewDTO toDTO(){
        return LtProductReviewDTO
                .builder()
                .revNo(revNo)
                .ordNo(ordNo)
                .prodNo(ltProductEntity.getProdNo())
                .content(content)
                .uid(uid)
                .rating(rating)
                .regIp(regIp)
                .rDate(rDate)
                .subRDate(rDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")))
                .prodName(ltProductEntity.getProdName())
                .uidMasking(uid.substring(0, 3)+"****")
                .build();
    }


}
