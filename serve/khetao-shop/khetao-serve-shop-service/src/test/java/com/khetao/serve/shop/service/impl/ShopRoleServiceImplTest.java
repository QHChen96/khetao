package com.khetao.serve.shop.service.impl;

import com.khetao.serve.shop.dto.register.RoleInfoDTO;
import com.khetao.serve.shop.service.ShopRoleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ShopRoleServiceImplTest {

    @Autowired
    private ShopRoleService shopRoleService;

    @Test
    public void createRole() {
        RoleInfoDTO roleInfo = new RoleInfoDTO();
        roleInfo.setIntro("用户");
        roleInfo.setRoleName("user");
        roleInfo.setShowName("user");
        System.out.println(shopRoleService.createRole(roleInfo));
    }

    @Test
    public void allocateUsers() {
        shopRoleService.allocateUsers(2L, Arrays.asList(3L));
    }


    @Test
    public void loadRoles() {
        System.out.println(shopRoleService.loadRoles(3L));
    }
}