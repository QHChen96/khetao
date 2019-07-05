package com.khetao.storage.model;

import java.math.BigInteger;

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
public class StorageResult {

    private String fileName;
    private String hash;
    private String namespace;
    private BigInteger fsize;

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public String getNamespace() {
        return namespace;
    }

    public void setNamespace(String namespace) {
        this.namespace = namespace;
    }

    public BigInteger getFsize() {
        return fsize;
    }

    public void setFsize(BigInteger fsize) {
        this.fsize = fsize;
    }

    @Override
    public String toString() {
        return "StorageResult{" +
                "fileName='" + fileName + '\'' +
                ", hash='" + hash + '\'' +
                ", namespace='" + namespace + '\'' +
                ", fsize=" + fsize +
                '}';
    }
}
