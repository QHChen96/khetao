package com.khetao.serve.shop.service.impl;

import com.khetao.base.service.BaseServiceImpl;
import com.khetao.enums.DelStatusEnum;
import com.khetao.enums.UsableStatusEnum;
import com.khetao.serve.shop.dto.register.ShopUserRegisterWithEmailDTO;
import com.khetao.serve.shop.entity.Shop;
import com.khetao.serve.shop.mapper.ShopMapper;
import com.khetao.serve.shop.service.ShopService;
import com.khetao.serve.shop.vo.ShopVO;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

/**
 * <p>
    * 店铺表 服务实现类
    * </p>
 *
 * @author chenqinhao
 * @email qhchen96@gmail.com
 * @since 2019-06-30
 * @version 1.0
 */
@Service
@AllArgsConstructor
public class ShopServiceImpl extends BaseServiceImpl<ShopMapper, Shop> implements ShopService {

    /**
     * 包装
     * @param shop
     * @return
     */
    private ShopVO wrapShopVO(Shop shop) {
        ShopVO shopVO = new ShopVO();
        BeanUtils.copyProperties(shop, shopVO);
        shopVO.setShopId(shop.getId());
        return shopVO;
    }

    /**
     * 创建商铺
     * @param emailDTO
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public ShopVO createShop(ShopUserRegisterWithEmailDTO emailDTO) {
        Shop shop = new Shop();
        shop.setUserId(emailDTO.getUserId());
        shop.setShopName(emailDTO.getShopName());
        initShop(shop);
        baseMapper.insert(shop);
        return wrapShopVO(shop);
    }

    private void initShop(Shop shop) {
        shop.setGmtCreate(LocalDateTime.now());
        shop.setGmtModify(LocalDateTime.now());
        shop.setIsDel(DelStatusEnum.DEFAULE.status());
        shop.setStatus(UsableStatusEnum.USABLE.status());
    }
}
