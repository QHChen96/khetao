package com.khetao.serve.shop.service;

import com.khetao.base.service.BaseService;
import com.khetao.serve.shop.dto.product.CategoryDTO;
import com.khetao.serve.shop.entity.Category;

/**
 * <p>
    * 商品分类表 服务类
    * </p>
 *
 * @author chenqinhao
 * @email qhchen96@gmail.com
 * @since 2019-06-29
 * @version 1.0
 */
public interface CategoryService extends BaseService<Category> {

    Category saveCategory(CategoryDTO categoryDTO);

    boolean hasChilds(Long id);

    Long delCategory(Long id);
}
