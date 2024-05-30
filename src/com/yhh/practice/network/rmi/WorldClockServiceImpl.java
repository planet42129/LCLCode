package com.yhh.practice.network.rmi;

import java.rmi.RemoteException;
import java.time.LocalDateTime;
import java.time.ZoneId;

/**
 * @author hyh
 * @date 2024/5/13
 */
public class WorldClockServiceImpl implements WorldClockService{
    @Override
    public LocalDateTime getCurrentTime(String zoneId) throws RemoteException {
        return LocalDateTime.now(ZoneId.of(zoneId)).withNano(0);
    }
}
