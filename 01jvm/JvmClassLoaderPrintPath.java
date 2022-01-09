import java.lang.reflect.Field;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.List;

/**
 * @author Joly
 * @Descriptopn 当出现jar包没有加载进去的时候，就可以这么输出类加载器加载的jar包来看看是不是路径给少了
 */
public class JvmClassLoaderPrintPath {

    public static void main(String[] args) {
        /** knowledge point:
         *       1.启动类加载器会在JVM启动时就去加载jre的一些核心jar包和/jre/classes
         *       2.启动类加载器是JVM底层运行的，使用C++写的。
         *       3.Launcher:是JVM启动后运行的第一个java类
         */
        // ===> file:/D:/ITTools/Java/jdk1.8.0_131/jre/lib/resources.jar
        // ===> file:/D:/ITTools/Java/jdk1.8.0_131/jre/lib/rt.jar
        // ===> file:/D:/ITTools/Java/jdk1.8.0_131/jre/lib/sunrsasign.jar
        // ===> file:/D:/ITTools/Java/jdk1.8.0_131/jre/lib/jsse.jar
        // ===> file:/D:/ITTools/Java/jdk1.8.0_131/jre/lib/jce.jar
        // ===> file:/D:/ITTools/Java/jdk1.8.0_131/jre/lib/charsets.jar
        // ===> file:/D:/ITTools/Java/jdk1.8.0_131/jre/lib/jfr.jar
        // ===> file:/D:/ITTools/Java/jdk1.8.0_131/jre/classes
        // 启动类加载器
        URL[] urls = sun.misc.Launcher.getBootstrapClassPath().getURLs();
        System.out.println("启动类加载器");
        for (URL url : urls) {
            System.out.println(" ===> " + url.toExternalForm());
        }

        // 扩展类加载器
        printClassloader("扩展类加载器", JvmClassLoaderPrintPath.class.getClassLoader().getParent());
        /** knowledge point:
         *  所以一个类被加载的时候，是先从应用类加载器开始找的
         */
        // 应用类加载器
        printClassloader("应用类加载器", JvmClassLoaderPrintPath.class.getClassLoader());

    }

    private static void printClassloader(String name, ClassLoader classLoader) {
        System.out.println();
        if (null != classLoader) {
            System.out.println(name + " Classloader -> " + classLoader.toString());
            printURLForClassloader(classLoader);
        } else {
            System.out.println(name + " Classloader -> null");
        }
    }

    private static void printURLForClassloader(ClassLoader classLoader) {
        Object ucp = insightField(classLoader, "ucp");
        Object path = insightField(ucp, "path");
        List paths = (List) path;
        for (Object p : paths) {
            System.out.println(" ===> " + p.toString());
        }
    }

    private static Object insightField(Object obj, String fName) {
        Field f = null;
        try {
            if (obj instanceof URLClassLoader) {
                f = URLClassLoader.class.getDeclaredField(fName);
            } else {
                f = obj.getClass().getDeclaredField(fName);
            }
            f.setAccessible(true);
            return f.get(obj);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }


}
