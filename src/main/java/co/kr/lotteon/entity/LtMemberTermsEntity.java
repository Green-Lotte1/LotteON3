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
@Table(name = "lt_member_terms")
public class LtMemberTermsEntity {
    @Id
    private String terms;
    private String privacy;
    private String location;
    private String finance;
    private String tax;

}
