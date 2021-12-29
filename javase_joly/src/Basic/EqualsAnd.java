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
        int high = IntegerCache.high;
    }

    private static class IntegerCache {
        static final int low = -128;
        static final int high;


        static {
            System.out.println("if run this code?");
            // high value may be configured by property
            int h = 127;
            String integerCacheHighPropValue =
                    sun.misc.VM.getSavedProperty("java.lang.Integer.IntegerCache.high");
            if (integerCacheHighPropValue != null) {
                try {
                    int i = parseInt(integerCacheHighPropValue);
                    i = Math.max(i, 127);
                    // Maximum array size is Integer.MAX_VALUE
                    h = Math.min(i, Integer.MAX_VALUE - (-low) - 1);
                } catch (NumberFormatException nfe) {
                    // If the property cannot be parsed into an int, ignore it.
                }
            }
            high = h;


            Integer[] cache = new Integer[(high - low) + 1];
            int j = low;
            for (int k = 0; k < cache.length; k++) {
                cache[k] = new Integer(j++);
            }


            // range [-128, 127] must be interned (JLS7 5.1.7)
            assert IntegerCache.high >= 127;
        }
    }
}
