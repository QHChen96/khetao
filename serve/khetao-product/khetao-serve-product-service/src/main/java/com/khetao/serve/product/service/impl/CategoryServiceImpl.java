package com.khetao.serve.product.service.impl;

import com.khetao.base.BaseServiceImpl;
import com.khetao.serve.product.entity.Category;
import com.khetao.serve.product.mapper.CategoryMapper;
import com.khetao.serve.product.service.CategoryService;
import org.springframework.stereotype.Service;


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

}
