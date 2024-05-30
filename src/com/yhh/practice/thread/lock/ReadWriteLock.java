package com.yhh.practice.thread.lock;

import java.util.Arrays;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 只允许一个线程写入（其他线程既不能写入也不能读取）；
 * 没有写入时，多个线程允许同时读（提高性能）。
 * 但是读的时候，不能写，需要等待其他读线程释放读锁才能写入
 *
 * 当申请写锁的时候，如果当前有若干正在读的读锁，那么就不允许后续准备申请读锁的去拿读锁了，
 * 这时会等到当前读锁全部释放后，拿到写锁。
 * 这么做的目的是，如果写锁没有高优先级，在大量线程不停读的情况下，写不进去
 * @author hyh
 * @date 2024/4/25
 */
public class ReadWriteLock {
    private final ReentrantReadWriteLock rwlock = new ReentrantReadWriteLock();
    private final Lock rlock = rwlock.readLock();
    private final Lock wlock = rwlock.writeLock();

    private int[] counts = new int[10];

    public void inc(int index) {
        wlock.lock(); // 加写锁
        try {
            counts[index] += 1;
        } finally {
            wlock.unlock(); // 释放写锁
        }
    }

    public int[] get() {
        rlock.lock(); // 加读锁
        try {
            return Arrays.copyOf(counts, counts.length);
        } finally {
            rlock.unlock(); // 释放读锁
        }
    }
}
