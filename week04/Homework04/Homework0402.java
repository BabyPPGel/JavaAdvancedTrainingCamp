package io.kimmking.spring02;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

public class Homework0402 {
    public static void main(String[] args) throws InterruptedException {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(2, new Runnable() {
            @Override
            public void run() {
                System.out.println("子线程执行结束。。。。");
            }
        });
        for (int i = 0; i < 2; i++) {
            new Thread(new sumNumber(i,cyclicBarrier)).start();
        }


        System.out.println("主线程执行结束。。。。");


    }
    static class sumNumber  implements Runnable{
        private int id;
        private CyclicBarrier cyc;
        public sumNumber(int id,CyclicBarrier cyc){
            this.id = id;
            this.cyc = cyc;
        }
        @Override
        public void run() {
            int sum =0;
            synchronized (this){
                System.out.println("id:"+id+","+Thread.currentThread().getName());
                try {
                    for(int i=1;i<1000 ;i++ ){
                        sum+=i;
                    }
                    cyc.await();
                    System.out.println("线程" + id + "结束,计算结果为"+sum);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}