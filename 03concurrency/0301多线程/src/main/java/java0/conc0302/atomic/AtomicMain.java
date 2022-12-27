
package java0.conc0302.atomic;

/**
 * TODOQQQQQQ
 * ��ʾLock�̲߳���ȫ
 * @author Joly
 */
public class AtomicMain {

    public static void main(String[] args) {
        final SyncCount count = new SyncCount();
        for (int i = 0; i < 100; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 10000; j++) {
                        count.add();
                    }
                }
            }).start();
        }

        try {
            Thread.sleep(5000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // TODO_Joly://num=338247 ���õ��ǹ�ƽ�����ò���ƽ���Ļ���������ǶԵ�
        // ���ȣ��Ҳ�����Ϊʲô�ܲ��ԣ�����Ҳ���������ƽզ��Ӱ����
        System.out.println("num=" + count.getNum());
    }

}
