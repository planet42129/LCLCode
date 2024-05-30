package com.yhh.practice.network.rmi;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

/**
 * @author hyh
 * @date 2024/5/13
 */
public class WorldClockProvider {
    public static void main(String[] args) throws RemoteException {
        WorldClockService worldClockService = new WorldClockServiceImpl();
        // 将此服务转换为远程服务接口:
        WorldClockService skeleton = (WorldClockService) UnicastRemoteObject
                .exportObject(worldClockService, 0);
        // 将RMI服务注册到1099端口:
        Registry registry = LocateRegistry.createRegistry(1099);
        // 注册此服务，服务名为"WorldClock":
        registry.rebind("WorldClockService", skeleton);
    }
}