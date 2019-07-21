package com.khetao.serve.product.service.impl;

import com.khetao.base.service.BaseServiceImpl;
import com.khetao.component.cache.redis.RedisManager;
import com.khetao.serve.product.entity.Brand;
import com.khetao.serve.product.mapper.BrandMapper;
import com.khetao.serve.product.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
    * 品牌表 服务实现类
    * </p>
 *
 * @author chenqinhao
 * @email qhchen96@gmail.com
 * @since 2019-06-29
 * @version 1.0
 */
@Service
public class BrandServiceImpl extends BaseServiceImpl<BrandMapper, Brand> implements BrandService {

    @Autowired
    private RedisManager<Brand> redisManager;


    public Brand getByCache(Long id) {
        String key = "khetao:brand:" + id;
        Brand brand = redisManager.get(key, Brand.class);
        if (null == brand) {
            brand = baseMapper.selectById(id);
            if (null == brand) {
                brand = new Brand();
            }
            redisManager.put(key, brand);
        }
        return brand;
    }

}
