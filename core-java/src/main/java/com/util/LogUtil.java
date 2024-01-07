package com.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Log utility class
 *
 * @author Srinath.Rayabarapu
 */
public class LogUtil {

    private static final Logger LOG = LoggerFactory.getLogger(LogUtil.class);

    public static void info(String infoString) {
        LOG.info(infoString);
    }

    public static void info(String s, Object obj) {
        LOG.info(s, obj);
    }
}
