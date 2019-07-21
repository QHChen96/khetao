package com.khetao.common.util;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

/**
 * <p>
 *
 * </p>
 *
 * @author chenqinhao
 * @version 1.0
 * @email qhchen96@gmail.com
 * @since 2019-07-21
 */
public class DateTimeUtil {

    /**
     * 当前时间戳 (秒)
     * @return
     */
    public static long timestampSeconds() {
        return LocalDateTime.now().toEpochSecond(ZoneOffset.ofHours(8));
    }

}
