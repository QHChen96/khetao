package com.khetao.storage;

import com.khetao.storage.model.StorageResult;

import java.io.File;
import java.io.InputStream;

/**
 * <p>
 *
 * </p>
 *
 * @author chenqinhao
 * @version 1.0
 * @email qhchen96@gmail.com
 * @since 2019-07-05
 */
public interface KhetaoStorage {

    StorageResult upload(String filePath, String fileName);

    StorageResult upload(byte[] data, String fileName);

    StorageResult upload(File file, String fileName);

    StorageResult upload(InputStream is, String fileName, String type);

    String privateDownloadUrl(String fileName);

    String downloadUrl(String fileName);

}
