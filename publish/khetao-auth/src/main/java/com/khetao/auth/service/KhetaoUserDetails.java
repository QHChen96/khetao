package com.khetao.auth.service;

import com.khetao.base.dto.KhetaoUser;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
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
@AllArgsConstructor
public class KhetaoUserDetails implements UserDetails {

    private KhetaoUser khetaoUser;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return khetaoUser.getAuthorities()
                .stream()
                .map(authority -> new SimpleGrantedAuthority(authority))
                .collect(Collectors.toList());
    }

    public KhetaoUser getKhetaoUser() {
        return khetaoUser;
    }

    @Override
    public String getPassword() {
        return khetaoUser.getPassword();
    }

    @Override
    public String getUsername() {
        return khetaoUser.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
