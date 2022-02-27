package io.kimmking.java8;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 用Collections操作完list以后，再使用stream来操作list
 *
 * @author 小虫子的小日常
 */
public class CollectionDemo {
    public static void main(String[] args) throws IOException {
        /** knowledge point:  用Arrays.asList的目的是简便操作，这样就不用new一个List出来，然后一个一个往里面加元素了*/
        List<Integer> list = Arrays.asList(4, 2, 3, 5, 1, 2, 2, 7, 6);   // Arrays还可以包装stream
        print(list);
        Collections.sort(list);
        print(list);
        Collections.reverse(list);
        print(list);
        Collections.shuffle(list);
        print(list);

        System.out.println(Collections.frequency(list, 2));
        System.out.println(Collections.max(list));

        Collections.fill(list, 8);
        print(list);

        list = Collections.singletonList(6);
        print(list);

    }

    private static void print(List<Integer> list) {
        System.out.println(String.join(",",
                list.stream()
                        .map(i -> i.toString())
                        .collect(Collectors.toList())
                        .toArray(new String[]{})));
    }

}
