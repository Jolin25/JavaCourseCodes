package io.kimmking.spring02;

import io.kimmking.spring01.Student;
import lombok.Data;

import java.util.List;

/**
 * û��ʵ�ֽӿ�
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
