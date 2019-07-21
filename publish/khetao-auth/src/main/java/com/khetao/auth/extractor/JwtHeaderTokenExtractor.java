package com.khetao.auth.extractor;

import org.apache.logging.log4j.util.Strings;
import org.springframework.security.authentication.AuthenticationServiceException;
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
@Component
public class JwtHeaderTokenExtractor implements TokenExtractor {

    public static final String HEADER_PREFIX = "Bearer ";

    /**
     * 提取token
     * @param header
     * @return
     */
    @Override
    public String extract(String header) {
        if (Strings.isBlank(header)) {
            throw new AuthenticationServiceException("Authentication header cannot be blank!");
        }
        if (header.length() < HEADER_PREFIX.length()) {
            throw new AuthenticationServiceException("Invalid authentication header size!");
        }
        return header.replace(HEADER_PREFIX, "");
    }


}
