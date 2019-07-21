package com.khetao.auth.security.jwt;

import com.khetao.auth.util.JwtPayload;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

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
public class JwtAuthenticationToken extends AbstractAuthenticationToken {

    private JwtPayload jwtPayload;
    private RawAccessJwtToken accessJwtToken;

    public JwtAuthenticationToken(RawAccessJwtToken accessJwtToken) {
        super(null);
        this.accessJwtToken = accessJwtToken;
        this.setAuthenticated(false);
    }

    public JwtAuthenticationToken(JwtPayload payload, Collection<? extends GrantedAuthority> authorities) {
        super(authorities);
        this.eraseCredentials();
        this.jwtPayload = payload;
        super.setAuthenticated(true);
    }



    @Override
    public Object getCredentials() {
        return accessJwtToken;
    }

    @Override
    public Object getPrincipal() {
        return jwtPayload;
    }

    @Override
    public void setAuthenticated(boolean authenticated) {
        if (authenticated) {
            throw new IllegalArgumentException("Cannot set this token to trusted - use constructor which takes a GrantedAuthority list instead");
        }
        super.setAuthenticated(false);
    }

    @Override
    public void eraseCredentials() {
        super.eraseCredentials();
        this.accessJwtToken = null;
    }
}
