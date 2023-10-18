package co.kr.lotteon.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "lt_cs_notice")
public class LtCsNoticeEntity {
	@Id
	private int noticeNo;

	private int cate1;
	private int cate2;

	private String title;
	private String content;
	private String writer;
	private String regip;
	@CreationTimestamp
	private LocalDateTime rdate;


	
}
