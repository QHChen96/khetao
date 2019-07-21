package com.khetao.serve.shop.service.impl;

import com.khetao.serve.shop.dto.register.EmailRegisterDTO;
import com.khetao.serve.shop.service.ShopUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ShopUserServiceImplTest {

    @Autowired
    private ShopUserService shopUserService;

    @Test
    public void loadUser() {

    }


    @Test
    public void createUser() {
        EmailRegisterDTO emailRegister = new EmailRegisterDTO();
        emailRegister.setEmail("qhchen96@gmail.com");
        emailRegister.setNickName("壳桃科技");
        emailRegister.setPassword("123456");
        System.out.println(shopUserService.createUser(emailRegister));
    }

    @Test
    public void allocateRoles() {
        shopUserService.allocateRoles(1L, Arrays.asList(1L, 2L));
    }

}