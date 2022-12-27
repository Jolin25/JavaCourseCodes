
package java0.conc0302.atomic;

/**
 * @author Joly
 */
public class Count {

    private int num = 0;

    public int add() {
        return num++;
    }

    public int getNum() {
        return num;
    }
}
