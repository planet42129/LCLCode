package com.yhh.practice.network.rmi;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.time.LocalDateTime;

/**
 * 因为客户端只有接口，并没有实现类，因此，客户端获得的接口方法返回值实际上是通过网络从服务器端获取的。
 * @author hyh
 * @date 2024/5/13
 */
public class WorldClockConsumer {
    public static void main(String[] args) throws RemoteException, NotBoundException {
        // 连接到服务器localhost，端口1099:
        Registry registry = LocateRegistry.getRegistry("localhost", 1099);
        // 查找名称为"WorldClock"的服务并强制转型为WorldClock接口:
        WorldClockService worldClock = (WorldClockService) registry.lookup("WorldClockService");

        // 正常调用接口方法:
        LocalDateTime now = worldClock.getCurrentTime("Asia/Shanghai");
        // 打印调用结果:
        System.out.println(now);
    }
}
