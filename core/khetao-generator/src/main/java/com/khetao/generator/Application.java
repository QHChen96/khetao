package com.khetao.generator;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;


/**
 * <p>
 *
 * </p>
 *
 * @author chenqinhao
 * @version 1.0
 * @email qhchen96@gmail.com
 * @since 2019-06-15
 */
@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
@MapperScan(basePackages = "com.khetao.generator.**.mapper")
@EnableConfigurationProperties
public class Application {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(Application.class, args);
        GeneratorConfigBean configBean = context.getBean(GeneratorConfigBean.class);
        new CodeGenerator(configBean).gen();
        ((ConfigurableApplicationContext) context).close();
    }

}
