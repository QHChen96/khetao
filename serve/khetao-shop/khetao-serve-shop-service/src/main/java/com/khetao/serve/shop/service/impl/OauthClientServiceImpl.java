package com.khetao.serve.shop.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.khetao.base.service.BaseServiceImpl;
import com.khetao.component.cache.redis.RedisManager;
import com.khetao.serve.shop.enums.OAuthClientCacheEnum;
import com.khetao.serve.shop.dto.OAuthClientDTO;
import com.khetao.serve.shop.entity.OauthClient;
import com.khetao.serve.shop.mapper.OauthClientMapper;
import com.khetao.serve.shop.service.OauthClientService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

/**
 * <p>
    *  服务实现类
    * </p>
 *
 * @author chenqinhao
 * @email qhchen96@gmail.com
 * @since 2019-07-06
 * @version 1.0
 */
@Service
@AllArgsConstructor
public class OauthClientServiceImpl extends BaseServiceImpl<OauthClientMapper, OauthClient> implements OauthClientService {

    private final RedisManager redisManager;

    @Override
    public Boolean revokeByClientId(String clientId) {
        String key = String.format(OAuthClientCacheEnum.OAUTH_CLIENT.key(), clientId);
        return redisManager.del(key);
    }

    @Override
    public OAuthClientDTO loadByClientId(String clientId) {
        String key = String.format(OAuthClientCacheEnum.OAUTH_CLIENT.key(), clientId);
        Object object = redisManager.get(key, OAuthClientDTO.class);
        OAuthClientDTO oAuthClientDTO = null;
        if (null == object) {
            QueryWrapper<OauthClient> param = new QueryWrapper<>();
            param.lambda().eq(OauthClient::getClientId, clientId);
            OauthClient oauthClient = baseMapper.selectOne(param);
            oAuthClientDTO = new OAuthClientDTO();
            if (null != oauthClient) {
                oAuthClientDTO.setClientId(oauthClient.getClientId());
                oAuthClientDTO.setClientSecret(oauthClient.getClientSecret());
                oAuthClientDTO.setRedirectUri(oauthClient.getRedirectUri());
                Set<String> scope = new TreeSet<>(Arrays.asList(oauthClient.getScope().split("[\\s+]")));
                Set<String> resources = new TreeSet<>(Arrays.asList(oauthClient.getResources().split("[\\s+]")));
                oAuthClientDTO.setScope(scope);
                oAuthClientDTO.setResources(resources);
            }
            // 空值也放入缓存，在一定程度上可以规避缓存穿透的问题
            redisManager.put(key, oauthClient, OAuthClientCacheEnum.OAUTH_CLIENT.seconds());
        } else {
            if (object instanceof OAuthClientDTO) {
                oAuthClientDTO = (OAuthClientDTO) object;
            }
        }
        return oAuthClientDTO;
    }

}
