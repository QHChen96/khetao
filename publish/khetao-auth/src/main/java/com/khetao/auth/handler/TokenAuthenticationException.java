package com.khetao.auth.handler;

import org.springframework.security.core.AuthenticationException;

/**
 * <p>
 *
 * </p>
 *
 * @author chenqinhao
 * @version 1.0
 * @email qhchen96@gmail.com
 * @since 2019-06-01
 */
public class TokenAuthenticationException extends AuthenticationException {

    public TokenAuthenticationException(String msg, Throwable t) {
        super(msg, t);
    }

}
