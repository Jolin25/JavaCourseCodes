package io.kimmking.spring02;

import io.kimmking.spring01.Student;
import lombok.Data;

import java.util.List;

/**
 * 1.演示：AOP
 * 没有实现接口：Spring默认使用CGLib来实现AOP
 *
 * @author Joly
 */
@Data
public class Klass {

    List<Student> students;

    /**
     * 咚
     *
     * @param
     * @return
     * @date 2022/2/7
     */
    public void dong() {
        System.out.println(this.getStudents());
    }

}
