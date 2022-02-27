package io.kimmking.java8;

import com.alibaba.fastjson.JSON;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

/**
 * stream
 *
 * @author Joly
 * @date 2022-2-27
 */
public class StreamDemo {

    public static void main(String[] args) throws IOException {
        //9个元素
        List<Integer> list = Arrays.asList(4, 2, 3, 5, 1, 2, 2, 7, 6);
        print(list);

        // Optional
        // Optional看样子是配合stream一起出现的，1.8.
        // DONE_Joly:Optional 的目的是什么 ---> 因为流操作的时候，如果返回的不是Optional，而是Integer一类的，那么有可能就会返回一个null，那么再往后操作
        //就会NPE，这个时候为了规避这种问题就采用了中间形式Optional，如果为空的话，就是Optional的value为空。
        // 那么这就说明了，所谓的终止操作只是逻辑上的，实际在语法层面并没有真的给终止操作带来的一个用户想要的数据形式，就像是Integer还是用Optional给封装了。
        Optional<Integer> first = list.stream()
                .findFirst();//终止操作--->查找与匹配：findFirst（）
        // DONE_Joly Optional 也有一套自己的类似stream的操作--->因为Optional是一个中间的形式，所以当然会有stream的那一套操作了
        //orElse的作用是如果为空，就使用orElse里的参数
        System.out.println(first.map(i -> i * 100).filter(i -> i > 100).orElse(100));

        //1,2,3
        // 0, 1, 2, 3
        // reduce:迭代式的进行数据操作：0+1=1,1+2=3,3+3=6，由于拿到第一个元素的时候没有与之对应的操作数，所以就需要我们给一个，这里给的0
        int sum = list.stream().filter(i -> i < 4).distinct().reduce(0, (a, b) -> a + b);
        System.out.println("sum=" + sum);

        //1,2,3
        // 1, 1, 2, 3
        int multi = list.stream().filter(i -> i < 4).distinct().reduce(1, (a, b) -> a * b);
        System.out.println("multi=" + multi);
        //Collectors.toMap(key,value)
        Map map1 = list.stream().collect(Collectors.toMap(a -> a, a -> (a + 1)));
        // DONE_Joly:parallel 是拿来做什么的--->指明可以采用多线程的方式来处理，默认是单线程的哒
        //Collectors.toMap(key,value,key重了取哪个value，用哪种Map来装值)
        Map<Integer, Integer> map = list.stream().parallel().collect(Collectors.toMap(a -> a, a -> (a + 1), (a, b) -> a, LinkedHashMap::new));
        print(map);

        //forEach的参数是个lambda表达式
        map.forEach((k, v) -> System.out.println("key:value = " + k + ":" + v));
        //parallelStream指明可以采用多线程的方式来处理
        List<Integer> list1 = map.entrySet().parallelStream().map(e -> e.getKey() + e.getValue()).collect(Collectors.toList());
        print(list1);

        // parallelStream()

        // 总结：
        // 1. Fluent API：继续Stream。   FluentAPI的意思就是说，可以一直点点点下去的操作，就是流操作
        // 2. 终止操作：得到结果


    }

    /**
     * 使用JSON的方式输出
     *
     * @param
     * @return
     * @date 2022-2-27
     */
    private static void print(Object obj) {
        System.out.println(JSON.toJSONString(obj));
    }
}
