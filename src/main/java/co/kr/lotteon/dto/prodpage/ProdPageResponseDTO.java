package co.kr.lotteon.dto.prodpage;

import co.kr.lotteon.dto.LtProductDTO;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
public class ProdPageResponseDTO {

    private List<LtProductDTO> dtoList;
    private int cate1;
    private int cate2;

    private int pg;
    private int size;
    private int total;

    private int start, end;
    private boolean prev, next;

    @Builder
    public ProdPageResponseDTO(ProdPageRequestDTO pageRequestDTO, List<LtProductDTO> dtoList, int total) {

        this.cate1 = pageRequestDTO.getCate1();
        this.cate2 = pageRequestDTO.getCate2();

        this.pg = pageRequestDTO.getPg();
        this.size = pageRequestDTO.getSize();
        this.total = total;
        this.dtoList = dtoList;

        this.end = (int) (Math.ceil(this.pg / 10.0) * 10);
        this.start = this.end - 9;
        int last = (int) (Math.ceil(total / (double) size));

        this.end = end > last ? last : end;
        this.prev = this.start > 1;
        this.next = total > this.end * this.size;

    }

}
