package co.kr.lotteon.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class LtProductOrderItemPK implements Serializable {
    @Column(name = "ordNo")

    private int ordNo;

    @Column(name = "prodNo")
    private int prodNo;
    @Override
    public boolean equals(Object o) {return false;  }

    @Override
    public int hashCode() {  return 0;}
}
