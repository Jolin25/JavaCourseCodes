package jrl;

/**
 * knowledge point:
 * 类初始化的时机
 */
public class NotInitialization {
    public static void main(String[] args) {

        SuperClass[] sca = new SuperClass[10];
        /**
         *  output :
         *
         * 通过数组定义来引用类不会触发此类的初始化
         * 虚拟机在运行时动态创建了一个数组类
         */
        System.out.println("----------------------------------------------------");
        new SuperClass();
        /**
         * output: SuperClass init!
         * 不是数组的话，就会在new的时候正常触发初始化了
         * */
        System.out.println("-----------------------------------------------------");
        System.out.println(SubClass.value);
        /**
         *  output : SuperClass init!
         *          1127
         *
         * 通过子类引用父类的静态对象不会导致子类的初始化
         * 只有直接定义这个字段的类才会被初始化
         */


        System.out.println(ConstClass.HELLOWORLD);
        /**
         *  output :
         *
         * 常量在编译阶段会存入调用类的常量池当中，本质上并没有直接引用到定义类常量的类，
         * 因此不会触发定义常量的类的初始化。
         * “hello world” 在编译期常量传播优化时已经存储到 NotInitialization 常量池中了。
         */
    }
}