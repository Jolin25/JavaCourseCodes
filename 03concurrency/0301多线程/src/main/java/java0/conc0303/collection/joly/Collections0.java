package java0.conc0303.collection.joly;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * @author jrl
 * @date Create in 19:25 2023/2/15
 */
public class Collections0 {
    public static void main(String[] args) {
        List<String> arrayList = new ArrayList<>();
        // 等于说对 用户的list进行了一层包装，类似于 AOP
        List<String> synchronizedList = Collections.synchronizedList(arrayList);
        synchronizedList.add("a");


        // 不可以对 集合 进行 crud
        List<String> unmodifiableList = Collections.unmodifiableList(arrayList);
        // Exception in thread "main" java.lang.UnsupportedOperationException
        unmodifiableList.set(1,"a");

    }
}
