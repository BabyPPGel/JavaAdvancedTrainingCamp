package io.github.kimmking.gateway.server;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.IntStream;

public class LockCount {
    private int sum=0;
    //可重入锁+公平锁
    private Lock lock=new ReentrantLock(true);
    public int addAndGet(){
        try {
            lock.lock();
            return ++sum;
        }finally {

             lock.unlock();

        }
    }
    public int getSum(){
       return sum;
    }



}
