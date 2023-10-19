package co.kr.lotteon.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LtProductCate2DTO {
    private int cate1;
    private int cate2;
    private String c2Name;
    private String c1Name;



}
