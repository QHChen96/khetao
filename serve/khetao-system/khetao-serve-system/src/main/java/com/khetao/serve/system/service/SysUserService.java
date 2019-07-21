package com.khetao.serve.system.service;

import com.khetao.base.service.BaseService;
import com.khetao.serve.system.entity.SysUser;

/**
 * <p>
    * 系统用户表 服务类
    * </p>
 *
 * @author chenqinhao
 * @email qhchen96@gmail.com
 * @since 2019-05-05
 * @version 1.0
 */
public interface SysUserService extends BaseService<SysUser> {

    /**
     * 获取用户
     * @param userName
     * @return
     */
    SysUser getByUserName(String userName);

}
