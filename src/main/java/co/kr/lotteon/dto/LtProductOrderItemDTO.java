package co.kr.lotteon.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.text.DecimalFormat;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LtProductOrderItemDTO {
    private String descript;
    private String ProdName;
    private int ordNo;
    private int prodNo;
    private int count;
    private int price;
    private int discount;
    private int point;
    private int delivery;
    private int total;

    private String thumb1;

    private int discountPrice;

    private int discountPriceTotal;

    public String getDiscountPriceTotalWithComma() {
        DecimalFormat df = new DecimalFormat("###,###");
        return df.format(price-(price*discount/100));
    }

    public String  getPriceWithComma() {
        DecimalFormat df = new DecimalFormat("###,###");
        return df.format(price);
    }

    public String getDeliveryWithComma() {

        DecimalFormat df = new DecimalFormat("###,###");
        return df.format(delivery);
    }


    public String getTotalWithComma() {

        DecimalFormat df = new DecimalFormat("###,###");
        return df.format(total);

    }
}
