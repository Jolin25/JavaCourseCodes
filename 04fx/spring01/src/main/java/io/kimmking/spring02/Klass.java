package io.kimmking.spring02;

import io.kimmking.spring01.Student;
import lombok.Data;

import java.util.List;

/**
 * 1.��ʾ��AOP
 * û��ʵ�ֽӿڣ�SpringĬ��ʹ��CGLib��ʵ��AOP
 *
 * @author Joly
 */
@Data
public class Klass {

    List<Student> students;

    /**
     * ��
     *
     * @param
     * @return
     * @date 2022/2/7
     */
    public void dong() {
        System.out.println(this.getStudents());
    }

}
