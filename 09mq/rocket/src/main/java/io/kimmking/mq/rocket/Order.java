package io.kimmking.mq.rocket;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * 就是个实体类
 * @author Joly
 * @date 2022/7/29
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    private long id;
    private String symbol;
    private double price;

}
