package io.kimmking.spring02;

import java.util.concurrent.CountDownLatch;

public class Homework0401 {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(2);
        for(int i=0;i<2;i++){
            new Thread(new sumNumber(i,countDownLatch)).start();
        }
        countDownLatch.await();
        System.out.println("==>各个子线程执行结束。。。。");
        System.out.println("==>主线程执行结束。。。。");
    }
    
    static class sumNumber  implements Runnable{

        private int id;
        private CountDownLatch latch;
        public  sumNumber(int id,CountDownLatch latch){
            this.id = id;
            this.latch = latch;
        }




        @Override
        public void run() {
            int sum=0;
            synchronized (this){
                System.out.println("id:"+id+","+Thread.currentThread().getName());
                for(int i=1;i<1000 ;i++ ){
                    sum+=i;
                }
                latch.countDown();
                System.out.println("线程组任务"+id+"结束，计算结果为"+sum+"其他任务继续");

            }
        }
    }
}