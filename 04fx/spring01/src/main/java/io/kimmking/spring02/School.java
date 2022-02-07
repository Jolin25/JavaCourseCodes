package io.kimmking.spring02;

import io.kimmking.aop.ISchool;
import io.kimmking.spring01.Student;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;

/**
 * @author Joly
 */
@Data
public class School implements ISchool {
    /**
     * knowledge point:
     * spring注入对象的方式：
     * Autowired注解：默认根据类型来注入
     *   required属性用于表示该对象A是服务启动的时候就把它注入到这个对象B中，
     *   还是等用到这个对象A的时候（也就是用到A的方法或者属性的时候）再把A注入进去B（也就是懒加载），
     *   默认是true，true就是一启动就注入
     * Resource注解：默认根据名字来注入
     */
    // Resource 
    @Autowired(required = true) //primary
            Klass class1;

    @Resource(name = "student100")
    Student student100;

    @Override
    public void ding() {

        System.out.println("Class1 have " + this.class1.getStudents().size() + " students and one is " + this.student100);

    }

}
