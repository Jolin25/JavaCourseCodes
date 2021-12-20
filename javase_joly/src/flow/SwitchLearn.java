package flow;

/**
 * @author jrl
 * @date Create in 10:44 2021-11-22
 */
public class SwitchLearn {
    public static void main(String[] args) {
        int a = 1;
        switch (a) {
            default:
                /** knowledge point:  defalut是不中才执行的，就算放在第一个也不会是默认执行的*/
                System.out.println("comes form default");
            case 1:
                a = 3;
                System.out.println("comes from 1");
            case 2:
                System.out.println("comes from 2");

        }
    }
}
