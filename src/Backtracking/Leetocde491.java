package Backtracking;

import java.util.List;

/**
 * @author zhujiaxi01
 * @date 2022-06-24 14:32
 */
public class Leetocde491 {
    private static int count;

    private static final Object object = new Object();
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (count < 100) {
                    synchronized (object) {
                        if ((count & 1) == 0) {
                            System.out.println(Thread.currentThread().getName() + ":" + count++);
                        }
                    }
                }

            }
        }, "偶数线程").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (count < 100) {
                    synchronized (object) {
                        if ((count & 1) == 1) {
                            System.out.println(Thread.currentThread().getName() + ":" + count++);
                        }
                    }
                }

            }
        }, "奇数线程").start();
    }
}
