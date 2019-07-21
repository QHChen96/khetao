package com.khetao.base.service;

import com.khetao.base.BaseAuth;

/**
 * <p>
 *
 * </p>
 *
 * @author chenqinhao
 * @version 1.0
 * @email qhchen96@gmail.com
 * @since 2019-07-09
 */
public interface AuthService {

    /**
     * 加载本地验证
     * @return
     */
    BaseAuth loadAuth(String account);

}
