package co.kr.lotteon.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LtProductReviewDTO {
    private int revNo;
    private int prodNo;
    private String content;
    private String uid;
    private int rating;
    private String regIp;
    private String rDate;

}
