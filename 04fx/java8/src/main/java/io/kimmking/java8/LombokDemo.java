package io.kimmking.java8;

import lombok.extern.java.Log;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * ��ʾLombok
 *
 * @author Joly
 * @date 2022/4/24
 */
@Log
public class LombokDemo {

    public static void main(String[] args) throws IOException {

        // Spring IoC
        // ServiceLoader.load  SPI
        // Listener/Callback
        // EventBus

        A a = new A(1, "KK");
        System.out.println(a.toString());
        A b = A.builder().age(1).name("KKK").build();

        new LombokDemo().demo();

        Student student1 = new Student();
        student1.setId(1);
        student1.setName("KK01");
        System.out.println(student1.toString());

        Student student2 = new Student(2, "KK02");
        //student2.init();
        System.out.println(student2.toString());
        new LombokDemo().testData();
    }

    private void demo() {
        /** knowledge point:
         *  ���log��idea���lombok����ڱ����������ɵ�
         * */
        log.info("demo in log.");
    }

    /**
     * ����Lombok��Dataע��
     *
     * @param
     * @return
     * @date 2022/4/24
     */
    private void testData() {
        new Student4Data("ֻ��name");
    }

}
