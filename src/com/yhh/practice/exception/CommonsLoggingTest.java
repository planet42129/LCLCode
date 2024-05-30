package com.yhh.practice.exception;

import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;

/**
 * @author hyh
 * @date 2024/4/30
 */
public class CommonsLoggingTest {
    public static void main(String[] args) {
        Log log = LogFactory.getLog(CommonsLoggingTest.class);
        log.info("start...");
        log.warn("end..");

    }
}
