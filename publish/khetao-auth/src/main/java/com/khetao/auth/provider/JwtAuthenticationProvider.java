package com.khetao.auth.provider;

import com.khetao.auth.exception.JwtAuthenticationException;
import com.khetao.auth.security.jwt.JwtAuthenticationToken;
import com.khetao.auth.security.jwt.RawAccessJwtToken;
import com.khetao.auth.util.JwtPayload;
import com.khetao.auth.util.JwtUtil;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

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
@Component
@SuppressWarnings("unchecked")
@AllArgsConstructor
public class JwtAuthenticationProvider implements AuthenticationProvider {

    private final JwtUtil jwtUtil;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        // 可进行黑名单判断策略
        RawAccessJwtToken accessJwtToken = (RawAccessJwtToken) authentication.getCredentials();
        JwtPayload payload = jwtUtil.decode(accessJwtToken.getToken());
        if (null == payload) {
            throw new JwtAuthenticationException("jwt token invalid!");
        }
        boolean isValid = jwtUtil.validate(payload);
        if (!isValid) {
            throw new JwtAuthenticationException("jwt token invalid!");
        }
        List<GrantedAuthority> authorities = payload.getAuthorities()
                .stream()
                .map(authority -> new SimpleGrantedAuthority(authority))
                .collect(Collectors.toList());
        return new JwtAuthenticationToken(payload, authorities);
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return JwtAuthenticationToken.class.isAssignableFrom(authentication);
    }
}
