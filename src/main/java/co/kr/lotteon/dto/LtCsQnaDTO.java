package co.kr.lotteon.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LtCsQnaDTO {
	
	private int qnaNo;
	private int cate1;
	private int cate2;
	private String title;
	private String content;
	private String file1;
	private String file2;
	private String file3;
	private String file4;
	private String writer;
	private String ordNo; //null 값 넣기 위해 String으로 변경 
	private String prodNo;
	private int parent;
	private int answerComplete;
	private String regip;
	private LocalDateTime rdate;

	private MultipartFile mFile1;

	//추가 필드
	private String writerName;
	private String c1Name;
	private String c2Name;
	private String writerMarking;
	private String rdateSub;


	
	
}
