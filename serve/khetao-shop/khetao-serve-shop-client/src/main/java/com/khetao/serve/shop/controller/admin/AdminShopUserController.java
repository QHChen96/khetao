package com.khetao.serve.shop.controller.admin;

import com.khetao.base.BaseController;
import com.khetao.base.BaseResult;
import com.khetao.serve.shop.dto.user.ShopUserDTO;
import com.khetao.serve.shop.entity.ShopUser;
import com.khetao.serve.shop.service.ShopUserService;
import com.khetao.serve.shop.vo.ShopUserVO;
import com.khetao.serve.shop.wrap.ShopUserWrapService;
import lombok.AllArgsConstructor;
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
@AllArgsConstructor
public class AdminShopUserController extends BaseController {

    private final ShopUserService shopUserService;

    private final ShopUserWrapService shopUserWrapService;
    /**
     * 用户列表
     * @return
     */
    @GetMapping(path = "/shopUsers")
    public BaseResult<List<ShopUser>> list() {
        return success(shopUserService.list(null));
    }

    /**
     * 保存用户
     * @param userId
     * @return
     */
    @PostMapping(path = "/shopUser/save")
    public BaseResult<ShopUserVO> saveRole(@RequestParam(name = "userId", required = false) Long userId, ShopUserDTO shopUserDTO) {
        ShopUserVO shopUserVO = shopUserWrapService.createShopUser(shopUserDTO);
        return success(shopUserVO);
    }

    /**
     * 分配角色
     * @param userId
     * @param roleIds
     * @return
     */
    @PostMapping(path = "/shopUser/allocate/{userId}")
    public BaseResult allocate(@PathVariable Long userId, List<Long> roleIds) {
        shopUserService.allocateRoles(userId, roleIds);
        return success();
    }

}
