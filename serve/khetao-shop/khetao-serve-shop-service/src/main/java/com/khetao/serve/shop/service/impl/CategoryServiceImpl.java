package com.khetao.serve.shop.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.khetao.base.exception.BaseServiceException;
import com.khetao.base.service.BaseServiceImpl;
import com.khetao.base.exception.NotFoundException;
import com.khetao.serve.shop.dto.product.CategoryDTO;
import com.khetao.serve.shop.entity.Category;
import com.khetao.serve.shop.mapper.CategoryMapper;
import com.khetao.serve.shop.service.CategoryService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;


/**
 * <p>
    * 商品分类表 服务实现类
    * </p>
 *
 * @author chenqinhao
 * @email qhchen96@gmail.com
 * @since 2019-06-29
 * @version 1.0
 */
@Service
public class CategoryServiceImpl extends BaseServiceImpl<CategoryMapper, Category> implements CategoryService {


    @Override
    public Long delCategory(Long id) {
        if (hasChilds(id)) {
            throw new BaseServiceException("请先删除子类");
        }
        baseMapper.deleteById(id);
        return id;
    }

    @Override
    public Category saveCategory(CategoryDTO categoryDTO) {
        if (null != categoryDTO.getId() && 0L == categoryDTO.getId()) {
            return null;
        }
        if (null == categoryDTO.getId()) {
            Category parentCate = baseMapper.selectById(categoryDTO.getParentId());
            if (null == parentCate) {
                throw new NotFoundException("未找到父级分类");
            }
            Category category = new Category();
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
        Category originCate = baseMapper.selectById(categoryDTO.getId());
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
        return baseMapper.selectCount(new QueryWrapper<Category>().lambda().eq(Category::getParentId, id)) > 0;
    }

}
