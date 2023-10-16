package co.kr.lotteon.dto;

import co.kr.lotteon.entity.LtCsCate1Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LtCsCate1DTO {
	
	private int cate1;
	private String c1Name;

	public LtCsCate1Entity toEntity(){
		return LtCsCate1Entity.builder()
				.cate1(cate1)
				.c1Name(c1Name)
				.build();
	}

}
