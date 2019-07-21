package com.khetao.serve.shop.mapper;

import com.khetao.serve.shop.entity.ShopResource;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
    * 商家资源表 Mapper 接口
    * </p>
 *
 * @author chenqinhao
 * @email qhchen96@gmail.com
 * @since 2019-06-30
 * @version 1.0
 */
public interface ShopResourceMapper extends BaseMapper<ShopResource> {

    /**
     * 分配多个资源
     * @param roleId
     * @param resourceIds
     */
    void allocateResources(Long roleId, List<Long> resourceIds);

    /**
     * 取消全部资源
     * @param roleId
     */
    void unallocateResources(Long roleId);

    /**
     * 分配资源
     * @param roleId
     * @param resourceId
     */
    void allocateResource(Long roleId, Long resourceId);

    /**
     * 取消资源
     * @param roleId
     * @param resourceId
     */
    void unallocateResource(Long roleId, Long resourceId);
}
