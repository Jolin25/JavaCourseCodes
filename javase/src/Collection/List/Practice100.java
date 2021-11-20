package Collection.List;

import java.util.Arrays;
import java.util.List;

/**
 * @author jrl
 * @date Create in 14:03 2021-11-17
 */
public class Practice100 {
    public static void main(String[] args) {
        Practice100 p_100 = new Practice100();
        p_100.arrayToList();
    }

    /**
     * @param
     * @return
     * @date 2021-11-17
     */
    private void arrayToList() {
        Integer[] arr = {1, 2, 3};
        List<Integer> list = Arrays.asList(arr);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
