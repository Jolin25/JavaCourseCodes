package java0.conc0303.future;

import java.util.Random;
import java.util.concurrent.*;

/**
 * Future��˳�����������̵߳��쳣���
 * �첽ͬ����ָ����ͨ��ģʽ���߳�A�������߳�Bȥ�ɻ�߳�A�Ƿ�Ҫ���Ե��߳�B�ɻ�Ľ����
 * ������������˵�����̵߳�״̬���Ƿ����CPU��Դ
 *
 * @author Joly
 */
public class FutureDemo1 {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();
        executor.submit(() -> {
            // ����� Runnable���쳣û�����
            int a = 1 / 0;
        });
        System.out.println("main1");
        //�첽�����������ǻ���һ���߳�Bȥ�ɻȻ��ǰ�߳�A������������ִ��,
        //���߳�Bִ������֮��x�Ὣ������͸�A�̡߳�
        Future<Integer> result = executor.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                //����� Callable���쳣����˱��̣߳����˸��߳�.������Ӱ�츸�̵߳�ִ��
                //���Ǳ��� Future#get �Ż������������������ʵ���Ǹ��߳��쳣��Ȼ��˳��չʾ�����̵߳��쳣
                int a = 1 / 0;
                Thread.sleep(10000);
                return new Random().nextInt();
            }
        });
        System.out.println("main2");
        executor.shutdown();
        try {
            //��������˵�����ʱ���п������ò�������İ�
            //����Java���̳߳�ʵ�������ˣ����̻߳�������߳�ִ���꣡
            //����һ���õõ�ֵ��
            //һ��Ҫȥ Future#get �Ż����߳��쳣�������get�Ļ���Ҳ���Լ��쳣�Լ��ģ�������Ӱ�츸�̡߳�
            System.out.println("result:" + result.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}