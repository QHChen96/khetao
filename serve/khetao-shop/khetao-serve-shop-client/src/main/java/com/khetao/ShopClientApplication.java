package com.khetao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;

/**
 * <p>
 *
 * </p>
 *
 * @author chenqinhao
 * @version 1.0
 * @email qhchen96@gmail.com
 * @since 2019-07-16
 */
@RefreshScope
@SpringBootApplication
public class ShopClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShopClientApplication.class, args);
    }

}
