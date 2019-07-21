package com.khetao.serve.shop.service;

import com.khetao.serve.shop.dto.resource.ResourceDTO;
import com.khetao.serve.shop.entity.ShopResource;
import com.khetao.base.service.BaseService;
import com.khetao.serve.shop.vo.ShopResourceVO;

import java.util.List;

/**
 * <p>
    * 商家资源表 服务类
    * </p>
 *
 * @author chenqinhao
 * @email qhchen96@gmail.com
 * @since 2019-06-30
 * @version 1.0
 */
public interface ShopResourceService extends BaseService<ShopResource> {

    /**
     * 创建资源
     * @param shopResource
     * @return
     */
    ShopResourceVO createResource(ResourceDTO shopResource);


    /**
     * 获取父级
     * @param parentId
     * @return
     */
    ShopResource getParent(Long parentId);

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

    /**
     * 修改资源
     * @param resId
     * @param resourceDTO
     * @return
     */
    ShopResourceVO updateResource(Long resId, ResourceDTO resourceDTO);
}
