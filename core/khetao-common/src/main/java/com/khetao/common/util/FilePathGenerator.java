package com.khetao.common.util;

import cn.hutool.core.util.IdUtil;
import cn.hutool.crypto.digest.MD5;

import java.time.LocalDate;

/**
 * <p>
 *
 * </p>
 *
 * @author chenqinhao
 * @version 1.0
 * @email qhchen96@gmail.com
 * @since 2019-09-21
 */
public class FilePathGenerator {

    static final String FILE_PATH_TEMP = "%s/%s/%s.%s";

    public static String path(String dir, String ext) {
        return String.format(FILE_PATH_TEMP, dir, MD5.create().digestHex16(LocalDate.now().toString()), IdUtil.objectId(), ext);
    }

}
