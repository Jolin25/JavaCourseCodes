package Basic;

import static java.lang.Integer.parseInt;

/**
 * 关于==
 *
 * @author jrl
 * @date Create in 15:07 2021-12-29
 */
public class EqualsAnd {


    public static void main(String[] args) {

        Integer a = 127; //Integer.valueOf(127)
        Integer b = 127; //Integer.valueOf(127)
        System.out.println("\nInteger a = 127;\n" +
                "Integer b = 127;\n" +
                "a == b ? {}" + (a == b));    // true

        Integer c = 128; //Integer.valueOf(128)
        Integer d = 128; //Integer.valueOf(128)
        System.out.println("\nInteger c = 128;\n" +
                "Integer d = 128;\n" +
                "c == d ? {}" + (c == d));   //false

        Integer e = 127; //Integer.valueOf(127)
        Integer f = new Integer(127); //new instance
        System.out.println("\nInteger e = 127;\n" +
                "Integer f = new Integer(127));\n" +
                "e == f ? {}" + (e == f));   //false

        Integer g = new Integer(127); //new instance
        Integer h = new Integer(127); //new instance
        System.out.println("\nInteger g = new Integer(127));\n" +
                "Integer h = new Integer(127));\n" +
                "g == h ? {}" + (g == h));  //false

        Integer i = 128; //unbox
        int j = 128;
        System.out.println("\nInteger i = 128;\n" +
                "int j = 128;\n" +
                "i == j ? {}" + (i == j)); //true
        assert 128 >= 127;
        // intern()方法，对字符串进行驻留
        String a1 = new String("a").intern();
        boolean b1 = a1 == "a";
        String b2 = new String("b");
        System.out.println(b1);
        System.out.println(b2 == "b");
    }


}
