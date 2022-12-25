
package java0.conc0302.lock;

/**
 * num++
 * 两个方法的两个锁的获取顺序不同
 *
 * @author Joly
 */
public class Count3 {

    private byte[] lock1 = new byte[1];
    private byte[] lock2 = new byte[1];

    public int num = 0;

    /**
     * num++
     * 使用两个锁来保证线程安全
     *
     * @param
     * @return
     * @date 2022/12/25
     */
    public void add() {
        // 对象锁lock1
        synchronized (lock1) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //对象锁lock2
            synchronized (lock2) {
                num += 1;
            }
            //执行完业务之后，释放第一个锁资源之前进行输出
            System.out.println(Thread.currentThread().getName() + "_" + num);
        }
    }

    /**
     * num++
     * 使用两个锁来保证线程安全
     *
     * @param
     * @return
     * @date 2022/12/25
     */
    public void lockMethod() {
        //对象锁lock2
        synchronized (lock2) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //对象锁lock1
            synchronized (lock1) {
                num += 1;
            }
            //执行完业务之后，释放第一个锁资源之前进行输出
            System.out.println(Thread.currentThread().getName() + "_" + num);
        }
    }


}
