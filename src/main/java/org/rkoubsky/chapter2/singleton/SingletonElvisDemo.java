package org.rkoubsky.chapter2.singleton;

import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author Radek Koubsky (radekkoubsky@gmail.com)
 */
public class SingletonElvisDemo {
    public static void main(final String[] args) {
        final Thread[] threads = new Thread[50];
        startThreads(threads);
        joinThreads(threads);
    }

    private static void startThreads(final Thread[] threads) {
        IntStream.range(0, threads.length).forEach(i -> {
            threads[i] = createThread();
            threads[i].start();
        });
    }

    private static Thread createThread() {
        final Thread thread = new Thread(() -> {
            System.out.println("Got a singleton instance: " + Elvis.INSTANCE);
        });

        return thread;
    }

    private static void joinThreads(final Thread[] threads) {
        Stream.of(threads).forEach(thread -> {
            join(thread);
        });
    }

    private static void join(final Thread thread) {
        try {
            thread.join();
        } catch (final InterruptedException e) {
            e.printStackTrace();
        }
    }
}
