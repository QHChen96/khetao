package com.khetao.serve.system.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.khetao.base.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

/**
 * <p>
    * 系统资源
    * </p>
 *
 * @author chenqinhao
 * @email qhchen96@gmail.com
 * @since 2019-05-05
 * @version 1.0
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("sys_resource")
public class SysResource extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 资源名
     */
    private String resName;

    /**
     * 资源类型  1 菜单 、2 按钮
     */
    private Integer resType;

    /**
     * 父id
     */
    private Long parentId;

    /**
     * 国际化
     */
    private String i18n;

    /**
     * 图标
     */
    private String icon;

    /**
     * 父路径
     */
    private String parents;

    /**
     * 简介
     */
    private String intro;

    /**
     * 状态 0不可用、1可用
     */
    private Integer status;

    /**
     * 是否删除 0否、1是
     */
    private Integer isDel;

    /**
     * 资源路径
     */
    private String resPath;

    /**
     * 创建时间
     */
    private LocalDateTime gmtCreate;

    /**
     * 修改时间
     */
    private LocalDateTime gmtModify;


}
