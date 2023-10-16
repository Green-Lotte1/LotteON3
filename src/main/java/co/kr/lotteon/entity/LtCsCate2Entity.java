package co.kr.lotteon.entity;

import co.kr.lotteon.dto.LtCsCate2DTO;
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
@Table(name = "lt_cs_cate2")
public class LtCsCate2Entity {
  
	private int cate1;
	@Id
	private int cate2;
	private String c2Name;
  
	public LtCsCate2DTO toDTO(){
		return LtCsCate2DTO.builder()
				.cate1(cate1)
				.cate2(cate2)
				.c2Name(c2Name)
				.build();
	}
}
