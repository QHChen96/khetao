package com.khetao.auth.security.jwt;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * <p>
 *
 * </p>
 *
 * @author chenqinhao
 * @version 1.0
 * @email qhchen96@gmail.com
 * @since 2019-07-21
 */
@Data
@ConfigurationProperties(prefix = "jwt")
@Component
public class JwtSettings {

    private String secretKey;
    private long expireSeconds;
    private String iss;


}
