package com.khetao.auth.security.jwt;

import com.khetao.auth.util.JwtPayload;
import lombok.AllArgsConstructor;

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
@AllArgsConstructor
public class AccessJwtToken implements JwtToken{

    private final String token;
    private final JwtPayload payload;

    @Override
    public String getToken() {
        return this.token;
    }

    public JwtPayload getPayload() {
        return this.payload;
    }
}
