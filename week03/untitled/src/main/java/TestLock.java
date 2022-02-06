package io.github.kimmking.gateway.server;

import java.util.stream.IntStream;

public class TestLock {
    public static void main(String[] args) {
        int loopNum = 100_0000;
        LockCount counter = new LockCount();
        IntStream.range(0, loopNum).parallel()
                .forEach(i -> counter.addAndGet());
    }
}
