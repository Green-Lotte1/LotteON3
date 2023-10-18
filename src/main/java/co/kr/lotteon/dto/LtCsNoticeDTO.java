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
public class LtCsNoticeDTO {
	private int noticeNo;
	private int cate1;
	private int cate2;
	private String title;
	private String content;
	private String writer;
	private String regip;

	private LocalDateTime rdate;

	private int hit;
	//추가필드
	private String c1Name;
	private String c2Name;
	private String rdateSub;

	
	
}
