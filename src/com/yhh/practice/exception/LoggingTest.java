package com.yhh.practice.exception;

import java.io.UnsupportedEncodingException;
import java.util.logging.Logger;

/**
 * @author hyh
 * @date 2024/4/30
 */
public class LoggingTest {
    public static void main(String[] args) {
/*        Logger logger = Logger.getGlobal();
        logger.info("start process...");
        logger.warning("memory is running out...");
        logger.fine("ignored.");
        logger.severe("process will be terminated...");*/

        Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
        logger.info("Start process...");
        try {
            "".getBytes("GBK");
        } catch (UnsupportedEncodingException e) {
            // TODO: 使用logger.severe()打印异常

            logger.severe("Invalid!");
            e.printStackTrace();
        }
        logger.info("Process end.");
    }
}
