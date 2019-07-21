package com.khetao.serve.shop.service.impl;

import com.khetao.serve.shop.dto.register.ShopUserRegisterWithEmailDTO;
import com.khetao.serve.shop.service.ShopService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ShopServiceImplTest {

    @Autowired
    private ShopService shopService;


    @Test
    public void createShop() {
        ShopUserRegisterWithEmailDTO emailDTO = new ShopUserRegisterWithEmailDTO();
        emailDTO.setPassword("123456");
        emailDTO.setPassword(new BCryptPasswordEncoder().encode(emailDTO.getPassword()));
        emailDTO.setEmail("elo0096@163.com");
        emailDTO.setNickName("鹿马");
        emailDTO.setShopName("鹿马科技");
        shopService.createShop(emailDTO);
    }
}