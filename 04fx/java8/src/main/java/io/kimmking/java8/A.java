package io.kimmking.java8;

import lombok.*;
import lombok.extern.slf4j.Slf4j;

/**
 * ÑÝÊ¾£ºLombok
 *
 * @author Joly
 * @date 2022/4/24
 */
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Slf4j
@Builder
@Getter
@Setter
public class A {

    private int age;

    private String name;

//    public void test(){
//        log.info("this message is logged by lombok");
//        System.out.println(this.toString());
//    }

}
