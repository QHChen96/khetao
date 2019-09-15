package com.khetao.serve.shop.controller.admin;

import com.khetao.base.BaseController;
import com.khetao.base.BaseResult;
import com.khetao.serve.shop.dto.resource.ResourceDTO;
import com.khetao.serve.shop.entity.ShopResource;
import com.khetao.serve.shop.service.ShopResourceService;
import com.khetao.serve.shop.vo.ShopResourceVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *
 * </p>
 *
 * @author chenqinhao
 * @version 1.0
 * @email qhchen96@gmail.com
 * @since 2019-07-20
 */
@RestController
@RequestMapping("/admin")
public class AdminShopResourceController extends BaseController {

    @Autowired
    private ShopResourceService shopResourceService;

    /**
     * 资源列表
     * @return
     */
    @GetMapping(path = "/shopResources")
    public BaseResult<ShopResource> list() {
        return success(shopResourceService.list(null));
    }


    @PostMapping(path = "/shopResource/save")
    public BaseResult<ShopResourceVO> saveResource(@RequestParam(name = "resId", required = false) Long resId, ResourceDTO resourceDTO) {
        ShopResourceVO shopResourceVO = null;
        if (null == resId) {
            shopResourceVO = shopResourceService.createResource(resourceDTO);
        } else {
            shopResourceVO = shopResourceService.updateResource(resId, resourceDTO);
        }
        return success(shopResourceVO);
    }

    @PostMapping(path = "/shopResource/allocate/{roleId}")
    public BaseResult allocate(@PathVariable Long roleId, List<Long> resIds) {
        shopResourceService.allocateResources(roleId, resIds);
        return success();
    }

}
