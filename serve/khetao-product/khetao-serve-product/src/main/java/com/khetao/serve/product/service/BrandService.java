package com.khetao.serve.product.service;

import com.khetao.base.service.BaseService;
import com.khetao.serve.product.entity.Brand;

/**
 * <p>
    * 品牌表 服务类
    * </p>
 *
 * @author chenqinhao
 * @email qhchen96@gmail.com
 * @since 2019-06-29
 * @version 1.0
 */
public interface BrandService extends BaseService<Brand> {

    Brand getByCache(Long id);

}
