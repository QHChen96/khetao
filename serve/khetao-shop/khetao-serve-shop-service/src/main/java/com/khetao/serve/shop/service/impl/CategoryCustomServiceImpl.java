package com.khetao.serve.shop.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.khetao.base.BaseServiceException;
import com.khetao.base.service.BaseServiceImpl;
import com.khetao.exception.NotFoundException;
import com.khetao.serve.shop.dto.product.CategoryCustomDTO;
import com.khetao.serve.shop.entity.CategoryCustom;
import com.khetao.serve.shop.mapper.CategoryCustomMapper;
import com.khetao.serve.shop.service.CategoryCustomService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
    * 商品分类表 服务实现类
    * </p>
 *
 * @author chenqinhao
 * @email qhchen96@gmail.com
 * @since 2019-09-18
 * @version 1.0
 */
@Service
public class CategoryCustomServiceImpl extends BaseServiceImpl<CategoryCustomMapper, CategoryCustom> implements CategoryCustomService {

    @Override
    public CategoryCustom saveCategory(CategoryCustomDTO categoryDTO) {
        if (null != categoryDTO.getId() && 0L == categoryDTO.getId()) {
            return null;
        }
        if (null == categoryDTO.getId()) {
            CategoryCustom parentCate = baseMapper.selectById(categoryDTO.getParentId());
            if (null == parentCate) {
                throw new NotFoundException("未找到父级分类");
            }
            CategoryCustom category = new CategoryCustom();
            BeanUtils.copyProperties(categoryDTO, category);
            category.setLevel(parentCate.getLevel() + 1);
            if (0L == parentCate.getId()) {
                category.setParents("0");
            } else {
                category.setParents(String.format("%s,%s", parentCate.getParents(), parentCate.getId()));
            }
            category.setGmtCreate(LocalDateTime.now());
            category.setGmtModify(LocalDateTime.now());
            baseMapper.insert(category);
            return category;
        }
        // 根节点不让修改
        CategoryCustom originCate = baseMapper.selectById(categoryDTO.getId());
        originCate.setCateName(categoryDTO.getCateName());
        originCate.setI18n(categoryDTO.getI18n());
        originCate.setIcon(categoryDTO.getIcon());
        originCate.setPriority(categoryDTO.getPriority());
        originCate.setGmtModify(LocalDateTime.now());
        baseMapper.updateById(originCate);
        return originCate;
    }

    @Override
    public boolean hasChilds(Long id) {
        return baseMapper.selectCount(new QueryWrapper<CategoryCustom>().lambda().eq(CategoryCustom::getParentId, id)) > 0;
    }

    @Override
    public Long delCategory(Long id, Long userId) {
        if (hasChilds(id)) {
            throw new BaseServiceException("请先删除子类");
        }
        baseMapper.delete(new QueryWrapper<CategoryCustom>().lambda().eq(CategoryCustom::getId, id).eq(CategoryCustom::getUserId, userId));
        return id;
    }

    @Override
    public List<CategoryCustom> listByUserShop(Long userId, Long shopId) {
        return baseMapper.selectList(new QueryWrapper<CategoryCustom>().lambda()
                .eq(CategoryCustom::getUserId, userId)
                .eq(CategoryCustom::getShopId, shopId)
                .or()
                .eq(CategoryCustom::getId, 0L));
    }
}
