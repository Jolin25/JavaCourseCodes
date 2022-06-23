package top.jrl.concurrency.part2;

/**
 * 因为balance为integer对象，当值被修改相当于换锁，
 * TODO 还有integer有缓存-128到127，相当于同一个对象。
 *
 * @author jrl
 * @date Create in 11:38 2022/5/15
 */
public class Integer1 {
    public static void main(String[] args) {
        Integer a = 1;
        Integer b = 2;
        System.out.println(a == b); // false
    }
}
