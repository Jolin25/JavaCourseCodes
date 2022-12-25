
package java0.conc0302.lock;

/**
 * num++
 * �����������������Ļ�ȡ˳��ͬ
 *
 * @author Joly
 */
public class Count3 {

    private byte[] lock1 = new byte[1];
    private byte[] lock2 = new byte[1];

    public int num = 0;

    /**
     * num++
     * ʹ������������֤�̰߳�ȫ
     *
     * @param
     * @return
     * @date 2022/12/25
     */
    public void add() {
        // ������lock1
        synchronized (lock1) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //������lock2
            synchronized (lock2) {
                num += 1;
            }
            //ִ����ҵ��֮���ͷŵ�һ������Դ֮ǰ�������
            System.out.println(Thread.currentThread().getName() + "_" + num);
        }
    }

    /**
     * num++
     * ʹ������������֤�̰߳�ȫ
     *
     * @param
     * @return
     * @date 2022/12/25
     */
    public void lockMethod() {
        //������lock2
        synchronized (lock2) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //������lock1
            synchronized (lock1) {
                num += 1;
            }
            //ִ����ҵ��֮���ͷŵ�һ������Դ֮ǰ�������
            System.out.println(Thread.currentThread().getName() + "_" + num);
        }
    }


}
