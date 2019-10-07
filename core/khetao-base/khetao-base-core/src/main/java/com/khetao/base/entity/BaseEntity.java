package com.khetao.base.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author chenqinhao qhchen96@gmail.com
 * @since 2019-05-04
 * @version 1.0
 **/
@Data
@Accessors(chain = true)
public class BaseEntity implements Serializable {

    private Serializable id;

    /**
     * 创建时间
     */
    private LocalDateTime gmtCreate;

    /**
     * 更新时间
     */
    private LocalDateTime gmtModify;

}
