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
@Table(name = "lt_member_point")
public class LtMemberPointEntity {
    @Id
    private int pointNo;
    private String uid;
    private int orderNo;
    private int point;
    private String pointDate;

}
