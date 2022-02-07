package io.kimmking.spring02;

import io.kimmking.spring01.Student;
import lombok.Data;

import java.util.List;

/**
 * 没有实现接口
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
