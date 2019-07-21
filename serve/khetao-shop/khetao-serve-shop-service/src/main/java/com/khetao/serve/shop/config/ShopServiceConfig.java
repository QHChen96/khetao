package com.khetao.serve.shop.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

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
@Configuration
@MapperScan(basePackages = {"com.khetao.serve.shop.mapper"})
public class ShopServiceConfig {



}
