package utils;


import org.apache.log4j.Logger;

public class LoggerUtil {
    private static final Logger logger = Logger.getLogger(LoggerUtil.class);

    private LoggerUtil() {
        // private constructor to prevent instantiation
    }

    public static void info(String message) {
        logger.info(message);
    }

    public static void error(String message) {
        logger.error(message);
    }

    // Add more logging methods as needed
}
