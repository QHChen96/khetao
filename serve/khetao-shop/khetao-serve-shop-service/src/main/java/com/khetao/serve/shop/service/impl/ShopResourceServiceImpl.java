package com.khetao.serve.shop.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.google.common.base.Joiner;
import com.khetao.base.service.BaseServiceImpl;
import com.khetao.base.enums.DelStatusEnum;
import com.khetao.base.enums.UsableStatusEnum;
import com.khetao.base.exception.NotFoundException;
import com.khetao.base.exception.RepulseOperationException;
import com.khetao.serve.shop.dto.resource.ResourceDTO;
import com.khetao.serve.shop.entity.ShopResource;
import com.khetao.serve.shop.enums.ResTypeEnum;
import com.khetao.serve.shop.mapper.ShopResourceMapper;
import com.khetao.serve.shop.service.ShopResourceService;
import com.khetao.serve.shop.vo.ShopResourceVO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
    * 商家资源表 服务实现类
    * </p>
 *
 * @author chenqinhao
 * @email qhchen96@gmail.com
 * @since 2019-06-30
 * @version 1.0
 */
@Service
public class ShopResourceServiceImpl extends BaseServiceImpl<ShopResourceMapper, ShopResource> implements ShopResourceService {

    /**
     * 装换
     * @param shopResource
     * @return
     */
    private ShopResourceVO wrapShopResourceVO(ShopResource shopResource) {
        ShopResourceVO shopResourceVO = new ShopResourceVO();
        BeanUtils.copyProperties(shopResource, shopResourceVO);
        return shopResourceVO;
    }

    /**
     * 创建资源 0为最高节点, 按钮类型不能创建子节点
     * @param resource
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public ShopResourceVO createResource(ResourceDTO resource) {
        ShopResource shopResource = new ShopResource();
        String parents = null;
        if (0 == resource.getParentId()) {
            parents = "/";
        } else {
            ShopResource parent = this.getParent(resource.getParentId());
            if (null == parent) {
                throw new NotFoundException("未找到父资源");
            }
            if (ResTypeEnum.FUNC.type() == parent.getResType()) {
                throw new RepulseOperationException("功能资源不允许添加子级");
            }
            parents = Joiner.on("").join(parent.getParents(), parent.getId(), "/");
        }
        BeanUtils.copyProperties(resource, shopResource);
        shopResource.setParents(parents);
        shopResource.setGmtCreate(LocalDateTime.now());
        shopResource.setGmtModify(LocalDateTime.now());
        shopResource.setStatus(UsableStatusEnum.USABLE.status());
        shopResource.setIsDel(DelStatusEnum.DEFAULE.status());
        baseMapper.insert(shopResource);
        return wrapShopResourceVO(shopResource);
    }

    /**
     * 修改资源
     * @param resId
     * @param resourceDTO
     * @return
     */
    @Override
    public ShopResourceVO updateResource(Long resId, ResourceDTO resourceDTO) {
        ShopResource shopResource = this.getById(resId);
        if (null == shopResource) {
            throw new NotFoundException("资源信息不存在!");
        }
        BeanUtils.copyProperties(resourceDTO, shopResource);
        shopResource.setGmtModify(LocalDateTime.now());
        baseMapper.updateById(shopResource);
        this.afterUpdate(shopResource);
        return wrapShopResourceVO(shopResource);
    }

    /**
     * 获取父资源
     * @param parentId
     * @return
     */
    @Override
    public ShopResource getParent(Long parentId) {
        QueryWrapper<ShopResource> query = new QueryWrapper<>();
        query.lambda().eq(ShopResource::getParentId, parentId);
        return baseMapper.selectOne(query);
    }

    /**
     * 分配资源
     * @param roleId
     * @param resourceIds
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void allocateResources(Long roleId, List<Long> resourceIds) {
        baseMapper.unallocateResources(roleId);
        baseMapper.allocateResources(roleId, resourceIds);
    }

    /**
     * 释放全部资源
     * @param roleId
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void unallocateResources(Long roleId) {
        baseMapper.unallocateResources(roleId);
    }

    /**
     * 分配资源
     * @param roleId
     * @param resourceId
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void allocateResource(Long roleId, Long resourceId) {
        baseMapper.allocateResource(roleId, resourceId);
    }

    /**
     * 释放资源
     * @param roleId
     * @param resourceId
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void unallocateResource(Long roleId, Long resourceId) {
        baseMapper.unallocateResource(roleId, resourceId);
    }



    private void afterUpdate(ShopResource shopResource) {
        // TODO
    }

}
