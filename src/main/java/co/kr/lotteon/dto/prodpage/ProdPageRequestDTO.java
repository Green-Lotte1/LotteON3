package co.kr.lotteon.dto.prodpage;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProdPageRequestDTO {

    @Builder.Default
    private int pg = 1;

    @Builder.Default
    private int size = 10;

    @Builder.Default
    private String how = "DESC";

    @Builder.Default
    private String sort = "sold";

    // cate Default 없으면 오류 발생 - Default 값을 지정해줘야함.
    @Builder.Default
    private int cate1 = 11;
    @Builder.Default
    private int cate2 = 11;

    public Pageable getPageable() {
        if (how.equals("ASC")) {
            return PageRequest.of(this.pg - 1, this.size, Sort.by(this.sort).ascending());
        } else {
            return PageRequest.of(this.pg - 1, this.size, Sort.by(this.sort).descending());
        }
    }


//    public Pageable getPageable(String sort) {
//        return PageRequest.of(this.pg-1, this.size, Sort.by(sort).descending());
//    }

}
