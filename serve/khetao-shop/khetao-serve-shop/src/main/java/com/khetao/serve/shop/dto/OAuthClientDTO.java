package com.khetao.serve.shop.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Set;

/**
 * <p>
 *
 * </p>
 *
 * @author chenqinhao
 * @version 1.0
 * @email qhchen96@gmail.com
 * @since 2019-07-06
 */
@Data
public class OAuthClientDTO implements Serializable {

    private String clientId;
    private String clientSecret;
    private String redirectUri;
    private Set<String> scope;
    private Set<String> resources;

}
