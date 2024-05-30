package com.yhh.practice.thread.lock;

import java.util.concurrent.locks.StampedLock;

/**
 * 乐观锁
 * 乐观读锁、悲观读锁
 * StampedLock : 采用乐观读锁，获取版本号long stamped（其实只是获取版本号，没有锁），允许读数据的时候，写线程获取写锁写数据；
 * 如果检查的版本号有变化，说明这期间有线程写入，这时候再采用悲观读锁去读数据。
 *
 * @author hyh
 * @date 2024/4/25
 */
public class Point {
    private final StampedLock stampedLock = new StampedLock();
    private int x;
    private int y;

    public void move(int x, int y) {
        long stamped = stampedLock.writeLock();//获取写锁
        try {
            this.x += x;
            this.y += y;
        } finally {
            stampedLock.unlockWrite(stamped);//释放写锁
        }
    }

    public double getDistanceFromOrigin() {
        long stamped = stampedLock.tryOptimisticRead();
        int currentX = this.x;
        //可能发生写入，导致读取的数据逻辑不一致，例如读到的x是写入前的数据，y是写入后的数据
        int currentY = this.y;
        if (stampedLock.validate(stamped) == false) {
            stamped = stampedLock.readLock();
            try {
                currentX = this.x;
                currentY = this.y;
            } finally {
                stampedLock.unlockRead(stamped);
            }
        }
        return Math.sqrt(currentX * currentX + currentY * currentY);

    }

}
/**
 * 和ReadWriteLock相比，写入的加锁是完全一样的，不同的是读取。
 * 注意到首先我们通过tryOptimisticRead()获取一个乐观读锁，并返回版本号。
 * 接着进行读取，读取完成后，我们通过validate()去验证版本号，
 * 如果在读取过程中没有写入，版本号不变，验证成功，我们就可以放心地继续后续操作。
 * 如果在读取过程中有写入，版本号会发生变化，验证将失败。在失败的时候，我们再通过获取悲观读锁再次读取。
 * 由于写入的概率不高，程序在绝大部分情况下可以通过乐观读锁获取数据，极少数情况下使用悲观读锁获取数据。
 *
 * 乐观锁其实不上锁，只检查版本号，它的目的是把read-write-lock的read加读锁这一步给去了，
 * 因为绝大多数情况下没有写，不需要加读锁。
 */