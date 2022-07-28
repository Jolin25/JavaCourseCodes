package io.kimmking.javacourse.kafka;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 就是个Order实体类
 *
 * @author Joly
 * @date 2022/7/23
 */

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Order { // 此类型为需要使用的消息内容

    private Long id;
    private Long ts;
    private String symbol;
    private Double price;

}
