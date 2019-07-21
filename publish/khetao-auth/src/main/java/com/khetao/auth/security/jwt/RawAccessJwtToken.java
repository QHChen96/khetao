package com.khetao.auth.security.jwt;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

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
@Slf4j
@AllArgsConstructor
public class RawAccessJwtToken implements JwtToken {

    private final String token;

    @Override
    public String getToken() {
        return this.token;
    }
}
