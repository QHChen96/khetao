package com.khetao.serve.product.service.impl;

import com.khetao.base.service.BaseServiceImpl;
import com.khetao.serve.product.entity.Product;
import com.khetao.serve.product.mapper.ProductMapper;
import com.khetao.serve.product.service.ProductService;
import org.springframework.stereotype.Service;

/**
 * <p>
    * 商品信息 服务实现类
    * </p>
 *
 * @author chenqinhao
 * @email qhchen96@gmail.com
 * @since 2019-06-29
 * @version 1.0
 */
@Service
public class ProductServiceImpl extends BaseServiceImpl<ProductMapper, Product> implements ProductService {

}
