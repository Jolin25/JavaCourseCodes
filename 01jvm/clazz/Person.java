package clazz;

/**
 * 配合TwoMethodClazz做练习
 *
 * @author Joly
 */
public class Person {
    int age;
    String name;
    final String GENDER = "女";
    final Long HEIGHT = 163L;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
