package com.khetao.serve.shop.service;

import com.khetao.serve.shop.dto.register.ShopUserRegisterWithEmailDTO;
import com.khetao.serve.shop.dto.shop.ShopBasicDTO;
import com.khetao.serve.shop.dto.shop.ShopWebInfoDTO;
import com.khetao.serve.shop.entity.Shop;
import com.khetao.base.service.BaseService;
import com.khetao.serve.shop.vo.ShopVO;

import java.util.List;

/**
 * <p>
    * 店铺表 服务类
    * </p>
 *
 * @author chenqinhao
 * @email qhchen96@gmail.com
 * @since 2019-06-30
 * @version 1.0
 */
public interface ShopService extends BaseService<Shop> {

    ShopVO createShop(ShopUserRegisterWithEmailDTO createShopWithEmail);

    List<Shop> queryUserShops(Long userId);

    Long saveBasic(ShopBasicDTO shopBasicDTO);

    void saveWebInfo(ShopWebInfoDTO shopWebInfoDTO);
}
