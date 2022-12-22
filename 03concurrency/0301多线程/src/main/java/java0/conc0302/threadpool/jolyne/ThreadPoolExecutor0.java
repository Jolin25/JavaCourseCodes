package java0.conc0302.threadpool.jolyne;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author jrl
 * @date Create in 14:23 2022/12/22
 */
public class ThreadPoolExecutor0 {
    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 10, 5000, TimeUnit.MILLISECONDS, new BlockingDeque<Runnable>() {
            @Override
            public void addFirst(Runnable runnable) {

            }

            @Override
            public void addLast(Runnable runnable) {

            }

            @Override
            public boolean offerFirst(Runnable runnable) {
                return false;
            }

            @Override
            public boolean offerLast(Runnable runnable) {
                return false;
            }

            @Override
            public void putFirst(Runnable runnable) throws InterruptedException {

            }

            @Override
            public void putLast(Runnable runnable) throws InterruptedException {

            }

            @Override
            public boolean offerFirst(Runnable runnable, long timeout, TimeUnit unit) throws InterruptedException {
                return false;
            }

            @Override
            public boolean offerLast(Runnable runnable, long timeout, TimeUnit unit) throws InterruptedException {
                return false;
            }

            @Override
            public Runnable takeFirst() throws InterruptedException {
                return null;
            }

            @Override
            public Runnable takeLast() throws InterruptedException {
                return null;
            }

            @Override
            public Runnable pollFirst(long timeout, TimeUnit unit) throws InterruptedException {
                return null;
            }

            @Override
            public Runnable pollLast(long timeout, TimeUnit unit) throws InterruptedException {
                return null;
            }

            @Override
            public boolean removeFirstOccurrence(Object o) {
                return false;
            }

            @Override
            public boolean removeLastOccurrence(Object o) {
                return false;
            }

            @Override
            public boolean add(Runnable runnable) {
                return false;
            }

            @Override
            public boolean offer(Runnable runnable) {
                return false;
            }

            @Override
            public void put(Runnable runnable) throws InterruptedException {

            }

            @Override
            public boolean offer(Runnable runnable, long timeout, TimeUnit unit) throws InterruptedException {
                return false;
            }

            @Override
            public Runnable remove() {
                return null;
            }

            @Override
            public Runnable poll() {
                return null;
            }

            @Override
            public Runnable take() throws InterruptedException {
                return null;
            }

            @Override
            public Runnable poll(long timeout, TimeUnit unit) throws InterruptedException {
                return null;
            }

            @Override
            public Runnable element() {
                return null;
            }

            @Override
            public Runnable peek() {
                return null;
            }

            @Override
            public boolean remove(Object o) {
                return false;
            }

            @Override
            public boolean contains(Object o) {
                return false;
            }

            @Override
            public int size() {
                return 0;
            }

            @Override
            public Iterator<Runnable> iterator() {
                return null;
            }

            @Override
            public void push(Runnable runnable) {

            }

            @Override
            public Runnable removeFirst() {
                return null;
            }

            @Override
            public Runnable removeLast() {
                return null;
            }

            @Override
            public Runnable pollFirst() {
                return null;
            }

            @Override
            public Runnable pollLast() {
                return null;
            }

            @Override
            public Runnable getFirst() {
                return null;
            }

            @Override
            public Runnable getLast() {
                return null;
            }

            @Override
            public Runnable peekFirst() {
                return null;
            }

            @Override
            public Runnable peekLast() {
                return null;
            }

            @Override
            public Runnable pop() {
                return null;
            }

            @Override
            public Iterator<Runnable> descendingIterator() {
                return null;
            }

            @Override
            public int remainingCapacity() {
                return 0;
            }

            @Override
            public int drainTo(Collection<? super Runnable> c) {
                return 0;
            }

            @Override
            public int drainTo(Collection<? super Runnable> c, int maxElements) {
                return 0;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }

            @Override
            public Object[] toArray() {
                return new Object[0];
            }

            @Override
            public <T> T[] toArray(T[] a) {
                return null;
            }

            @Override
            public boolean containsAll(Collection<?> c) {
                return false;
            }

            @Override
            public boolean addAll(Collection<? extends Runnable> c) {
                return false;
            }

            @Override
            public boolean removeAll(Collection<?> c) {
                return false;
            }

            @Override
            public boolean retainAll(Collection<?> c) {
                return false;
            }

            @Override
            public void clear() {

            }
        }, new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                Thread thread = new Thread(r);
                thread.setName("pool0" + "thread" + Math.random());
                return thread;
            }
        });
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("hello");
            }
        };
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        threadPoolExecutor.submit(runnable);
        threadPoolExecutor.execute(runnable);
        threadPoolExecutor.execute(runnable);
        threadPoolExecutor.execute(runnable);
        threadPoolExecutor.execute(runnable);
        threadPoolExecutor.execute(runnable);
        threadPoolExecutor.execute(runnable);
        threadPoolExecutor.execute(runnable);
        threadPoolExecutor.execute(runnable);
        threadPoolExecutor.execute(runnable);
        threadPoolExecutor.execute(runnable);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
