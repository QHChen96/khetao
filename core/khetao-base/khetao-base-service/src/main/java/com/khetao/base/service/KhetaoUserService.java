package com.khetao.base.service;

import com.khetao.dto.KhetaoUser;

/**
 * <p>
 *
 * </p>
 *
 * @author chenqinhao
 * @version 1.0
 * @email qhchen96@gmail.com
 * @since 2019-07-10
 */
public interface KhetaoUserService {

    /**
     * 获取用户信息
     * @param account
     * @return
     */
    KhetaoUser loadUser(String account);

    /**
     * 检查黑名单
     * @param token
     * @return
     */
    boolean checkBlackList(String token);


    void blockToken(String token);

}
