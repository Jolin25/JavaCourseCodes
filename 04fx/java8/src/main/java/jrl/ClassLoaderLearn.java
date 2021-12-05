package jrl;


public class ClassLoaderLearn {
    static double a = Math.random();

    static {
        System.out.println("初始化代码块");
        System.out.println("静态代码块中a的值为：" + a);
    }

    public ClassLoaderLearn() {
        System.out.println("构造函数");
        System.out.println("静态变量a的值为：" + a);
    }

    /**
     * knowledge point:
     *  静态属性的初始化和静态方法的执行，只会执行一次。是在类加载阶段。
     *  创建对象阶段会执行构造函数。
     */
    public static void main(String[] args) {
        for (int i = 0; i < 2; i++) {
            new ClassLoaderLearn();
            System.out.println("主方法中a的值："+a);
        }
    }
}