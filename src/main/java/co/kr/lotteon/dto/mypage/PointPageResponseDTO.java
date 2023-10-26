package co.kr.lotteon.dto.mypage;


import co.kr.lotteon.dto.LtCsFaqDTO;
import co.kr.lotteon.dto.LtCsNoticeDTO;
import co.kr.lotteon.dto.LtCsQnaDTO;
import co.kr.lotteon.dto.LtMemberPointDTO;
import co.kr.lotteon.dto.cspage.CsPageRequestDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.time.LocalDate;
import java.util.List;

@Data
public class PointPageResponseDTO {

    private List<LtMemberPointDTO> pointList;

    private int pg;
    private int size;
    private int total;

    private int start, end;
    private boolean prev, next;

    private String sort;
    private String how;
    private String searchType;
    private String searchKeyword;
    private LocalDate beginDate;
    private LocalDate endDate;

    @Builder
    public PointPageResponseDTO(PointPageRequestDTO pageRequestDTO,
                             List<LtMemberPointDTO> pointList, int total) {
        this.pg = pageRequestDTO.getPg();
        this.size = pageRequestDTO.getSize();
        this.total = total;
        this.sort = pageRequestDTO.getSort();
        this.how = pageRequestDTO.getHow();
        this.searchType = pageRequestDTO.getSearchType();
        this.searchKeyword = pageRequestDTO.getSearchKeyword();
        this.beginDate = pageRequestDTO.getBeginDate();
        this.endDate = pageRequestDTO.getEndDate();

        this.pointList = pointList;

        this.end = (int) (Math.ceil(this.pg / 10.0)) * 10;
        this.start = this.end - 9;
        int last = (int)(Math.ceil(total / (double)size));

        this.end = end > last ? last:end;
        this.end = end == 0 ? 1 : end;
        this.prev = this.start > 1;
        this.next = total > this.end * this.size;
    }
}
