package com.khetao.serve.shop.service;

import com.khetao.serve.shop.dto.OAuthClientDTO;
import com.khetao.serve.shop.entity.OauthClient;
import com.khetao.base.service.BaseService;

/**
 * <p>
    *  服务类
    * </p>
 *
 * @author chenqinhao
 * @email qhchen96@gmail.com
 * @since 2019-07-06
 * @version 1.0
 */
public interface OauthClientService extends BaseService<OauthClient> {

    /**
     * 加载客户端缓存
     * @param clientId
     * @return
     */
    OAuthClientDTO loadByClientId(String clientId);

    /**
     * 清除客户端缓存
     * @param clientId
     * @return
     */
    Boolean revokeByClientId(String clientId);

}
