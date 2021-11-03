package java0.conc0301.op;

public  class Join {

    public static void main(String[] args) throws InterruptedException {
        Object oo = new Object();

        MyThread thread1 = new MyThread("thread1 -- ");
//        oo = thread1;
        thread1.setOo(oo);
        thread1.start();
        Thread.sleep(1000);
        System.out.println("main Lock:" + oo.toString());
        System.out.println("main holds lock----" + Thread.holdsLock(oo));
        /** knowledge point:
         *      这里用oo和thread1是不一样的，因为对于join这个方法本身就涉及到了对thread1的锁。
         *      对于wait实践后也不一样，推测和thread1 执行完后就不存在对thread1的锁的这么一个情况
         * */
        synchronized (oo) {  // 这里用oo或thread1/this
            System.out.println("main inner holds lock----" + Thread.holdsLock(oo));
            for (int i = 0; i < 10; i++) {
                if (i == 2) {
                    try {
//                        oo.wait();
//                        System.out.println("main before join----" + Thread.holdsLock(oo));
                        /** knowledge point:  对呀，join是不会释放对象锁的，但是会释放对象为线程的锁，这里就是对thread1的锁会被main释放掉*/
                        thread1.join();
//                        System.out.println("main after join----" + Thread.holdsLock(oo));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(Thread.currentThread().getName() + " -- " + i);
            }
        }
    }

}

class MyThread extends Thread {

    private String name;
    private Object oo;

    public void setOo(Object oo) {
        this.oo = oo;
    }

    public MyThread(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("thread1 Lock:" + oo.toString());
        System.out.println("thread1----" + Thread.holdsLock(oo));
        synchronized (oo) { // 这里用oo或this，效果不同
            for (int i = 0; i < 10; i++) {
                System.out.println(name + i);
            }
//            oo.notify();
        }
    }

}