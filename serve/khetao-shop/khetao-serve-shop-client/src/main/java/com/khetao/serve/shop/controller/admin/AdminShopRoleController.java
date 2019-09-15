package com.khetao.serve.shop.controller.admin;

import com.khetao.base.BaseController;
import com.khetao.base.BaseResult;
import com.khetao.serve.shop.dto.register.RoleInfoDTO;
import com.khetao.serve.shop.entity.ShopRole;
import com.khetao.serve.shop.service.ShopRoleService;
import com.khetao.serve.shop.vo.ShopRoleVO;
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
public class AdminShopRoleController extends BaseController {

    @Autowired
    private ShopRoleService shopRoleService;

    /**
     * 角色列表
     * @return
     */
    @GetMapping(path = "/shopRoles")
    public BaseResult<List<ShopRole>> listShopRole() {
        List<ShopRole> list = shopRoleService.list(null);
        return success(list);
    }

    /**
     * 保存角色
     * @param roleId
     * @param roleInfoDTO
     * @return
     */
    @PostMapping(path = "/shopRole/save")
    public BaseResult saveRole(@RequestParam(name = "roleId", required = false) Long roleId, RoleInfoDTO roleInfoDTO) {
        ShopRoleVO shopRoleVO = null;
        if (null == roleId) {
            shopRoleVO = shopRoleService.createRole(roleInfoDTO);
        } else {
            shopRoleVO = shopRoleService.updateRole(roleId, roleInfoDTO);
        }
        return success(shopRoleVO);
    }

    /**
     * 分配用户
     * @param roleId
     * @param userIds
     * @return
     */
    @PostMapping(path = "/shopRole/allocate/{roleId}")
    public BaseResult allocate(@PathVariable Long roleId, List<Long> userIds) {
        shopRoleService.allocateUsers(roleId, userIds);
        return success();
    }




}
