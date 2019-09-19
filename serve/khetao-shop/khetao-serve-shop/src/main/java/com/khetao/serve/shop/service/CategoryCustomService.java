package com.khetao.serve.shop.service;

import com.khetao.base.service.BaseService;
import com.khetao.serve.shop.dto.product.CategoryCustomDTO;
import com.khetao.serve.shop.entity.CategoryCustom;

import java.util.List;

/**
 * <p>
    * 商品分类表 服务类
    * </p>
 *
 * @author chenqinhao
 * @email qhchen96@gmail.com
 * @since 2019-09-18
 * @version 1.0
 */
public interface CategoryCustomService extends BaseService<CategoryCustom> {

    CategoryCustom saveCategory(CategoryCustomDTO categoryDTO);

    boolean hasChilds(Long id);

    Long delCategory(Long id, Long userId);

    List<CategoryCustom> listByUserShop(Long userId, Long shopId);

}
