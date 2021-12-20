package BigDecimal;

import java.math.BigDecimal;

/**
 * @author jrl
 * @date Create in 14:37 2021-11-22
 */
public class BigDecimalBasic {
    public static void main(String[] args) {
        BigDecimal b = new BigDecimal("1.111");
        BigDecimal divide = b.divide(new BigDecimal("100"));
        System.out.println(divide+" "+b);
        b.toString();
    }
}
