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
     * springע�����ķ�ʽ��
     * Autowiredע�⣺Ĭ�ϸ���������ע��
     *   required�������ڱ�ʾ�ö���A�Ƿ���������ʱ��Ͱ���ע�뵽�������B�У�
     *   ���ǵ��õ��������A��ʱ��Ҳ�����õ�A�ķ����������Ե�ʱ���ٰ�Aע���ȥB��Ҳ���������أ���
     *   Ĭ����true��true����һ������ע��
     * Resourceע�⣺Ĭ�ϸ���������ע��
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
