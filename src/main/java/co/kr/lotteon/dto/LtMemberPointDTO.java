package co.kr.lotteon.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LtMemberPointDTO {
    private int pointNo;
    private String uid;
    private int orderNo;
    private int point;
    private String pointDate;

}
