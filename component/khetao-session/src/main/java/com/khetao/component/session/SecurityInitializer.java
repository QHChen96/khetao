package com.khetao.component.session;

import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

/**
 * <p>
 *
 * </p>
 *
 * @author chenqinhao
 * @version 1.0
 * @email qhchen96@gmail.com
 * @since 2019-05-09
 */
public class SecurityInitializer extends AbstractSecurityWebApplicationInitializer {

    public SecurityInitializer() {
        super(SecurityConfig.class, SessionConfig.class);
    }

}
