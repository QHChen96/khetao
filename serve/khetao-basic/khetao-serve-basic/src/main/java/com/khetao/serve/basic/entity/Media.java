package com.khetao.serve.basic.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.khetao.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

/**
 * <p>
    * 媒体表
    * </p>
 *
 * @author chenqinhao
 * @email qhchen96@gmail.com
 * @since 2019-06-30
 * @version 1.0
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("basic_media")
public class Media extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 上传人类型
     */
    private Integer uploaderType;

    /**
     * 上传人id
     */
    private Long uploaderId;

    /**
     * 媒体地址
     */
    private String mediaPath;

    /**
     * 媒体大小，单位K
     */
    private Long mediaSize;

    /**
     * 媒体类型
     */
    private Integer mediaType;

    /**
     * 媒体标题
     */
    private String mediaTitle;

    /**
     * 拓展名
     */
    private String mediaExt;

    /**
     * 创建时间
     */
    private LocalDateTime gmtCreate;

    /**
     * 修改时间
     */
    private LocalDateTime gmtModify;


}
