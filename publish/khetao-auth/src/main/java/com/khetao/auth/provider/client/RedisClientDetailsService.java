package com.khetao.auth.provider.client;

import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.security.oauth2.provider.NoSuchClientException;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 *  客户端
 * </p>
 *
 * @author chenqinhao
 * @version 1.0
 * @email qhchen96@gmail.com
 * @since 2019-07-06
 */
public class RedisClientDetailsService implements ClientDetailsService {

    private Map<String, ClientDetails> clientDetailsStore = new HashMap<String, ClientDetails>();

    public void setClientDetailsStore(Map<String, ClientDetails> clientDetailsStore) {
        this.clientDetailsStore = clientDetailsStore;
    }

    @Override
    public ClientDetails loadClientByClientId(String clientId) throws ClientRegistrationException {
        ClientDetails details = clientDetailsStore.get(clientId);
        if (details == null) {
            throw new NoSuchClientException("No client with requested id: " + clientId);
        }
        return details;
    }
}
