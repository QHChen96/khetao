package com.khetao.auth.provider.approval;

import com.khetao.component.cache.redis.RedisManager;
import org.springframework.security.oauth2.provider.approval.Approval;
import org.springframework.security.oauth2.provider.approval.ApprovalStore;

import java.util.Collection;

/**
 * <p>
 *  用户批准
 * </p>
 *
 * @author chenqinhao
 * @version 1.0
 * @email qhchen96@gmail.com
 * @since 2019-07-06
 */
public class RedisApprovalStore implements ApprovalStore {

    private RedisManager redisManager;

    public void setRedisManager(RedisManager redisManager) {
        this.redisManager = redisManager;
    }

    @Override
    public boolean addApprovals(Collection<Approval> approvals) {

        return false;
    }

    @Override
    public boolean revokeApprovals(Collection<Approval> approvals) {
        return false;
    }

    @Override
    public Collection<Approval> getApprovals(String userId, String clientId) {
        return null;
    }
}
