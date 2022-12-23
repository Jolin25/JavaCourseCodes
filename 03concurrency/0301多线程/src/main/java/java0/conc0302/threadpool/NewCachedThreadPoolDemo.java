
package java0.conc0302.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * NewCachedThreadPool������һ���ɻ�����̳߳ء�
 * ����̳߳صĴ�С�����˴�������������̣߳���ô�ͻ�����ⲿ���̣߳�60s ��ִ������ģ���
 * ����������ʱ�����̳߳��ֻ������߳���������߳�����ȫ�����ڲ���ϵͳ�ܹ��������߳�����
 * @author Joly
 */
public class NewCachedThreadPoolDemo {

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newCachedThreadPool();

        for (int i = 0; i < 10000; i++) {
            final int no = i;
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    try {
                        System.out.println("start:" + no);
                        Thread.sleep(1000L);
                        System.out.println("end:" + no);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };
            executorService.execute(runnable);
        }
        executorService.shutdown();
        System.out.println("Main Thread End!");


    }

}
