package java0.conc0303.collection.joly;

import java.util.Arrays;
import java.util.List;

/**
 * @author jrl
 * @date Create in 19:35 2023/2/15
 */
public class Arrays0 {
    public static void main(String[] args) {
        List<Integer> asList = Arrays.asList(1, 2, 3);
        asList.set(1,1);
        // 这里调用的是 AbstractList 里的 add（） 方法，也就是说，List 默认实现就是不让加减元素个数
        // 所以这里会 抛异常Exception in thread "main" java.lang.UnsupportedOperationException
        asList.add(1);
    }
}
