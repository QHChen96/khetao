package com.khetao.auth.service;

import com.khetao.base.service.KhetaoUserService;
import com.khetao.base.dto.KhetaoUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

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
@Service
@Primary
public class KhetaoUserDetailsService implements UserDetailsService {

    @Autowired
    private KhetaoUserService khetaoUserService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        KhetaoUser khetaoUser = khetaoUserService.loadUser(username);
        if (null == khetaoUser || null == khetaoUser.getUserId()) {
            throw new UsernameNotFoundException("User not found");
        }
        return new KhetaoUserDetails(khetaoUser);
    }


}
