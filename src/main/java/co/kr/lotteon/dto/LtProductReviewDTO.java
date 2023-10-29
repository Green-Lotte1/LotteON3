package co.kr.lotteon.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LtProductReviewDTO {
    private int revNo;
    private int ordNo;
    private int prodNo;
    private String content;
    private String uid;
    private int rating;
    private String regIp;
    private LocalDateTime rDate;

    //추가필드
    private String prodName;
    private String subRDate;
    private String uidMasking;
}
