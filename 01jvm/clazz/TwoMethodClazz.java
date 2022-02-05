package clazz;

/**
 * 生成字节码文件，研究该字节码文件如何对应JVM以及如何对应java
 *
 * @author Joly
 */
public class TwoMethodClazz {

    static {
        System.out.println("静态代码块");
    }

    private static String s1 = "静态变量";

    public static void main(String[] args) {
        TwoMethodClazz tmc = new TwoMethodClazz();
        int c1 = tmc.one();
        System.out.println("finish");
        Person p = new Person();
        tmc.two(c1, p);
    }

    public int one() {
        int a = 1;
        int b = 2;
        int c = a + b;
        return c;
    }

    private void two(int aa, Person pp) {
        System.out.println(aa + 1);
        pp.setAge(26);
        pp.setName("Joly");
    }
}
