package com.yhh.practice.network.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.time.LocalDateTime;

/**
 * @author hyh
 * @date 2024/5/13
 */
public interface WorldClockService extends Remote {
    LocalDateTime getCurrentTime(String zoneId) throws RemoteException;
}
