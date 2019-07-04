package com.khetao.serve.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.khetao.base.BaseServiceImpl;
import com.khetao.serve.system.entity.SysUser;
import com.khetao.serve.system.mapper.SysUserMapper;
import com.khetao.serve.system.service.SysUserService;
import org.springframework.stereotype.Service;


/**
 * <p>
    * 系统用户表 服务实现类
    * </p>
 *
 * @author chenqinhao
 * @email qhchen96@gmail.com
 * @since 2019-05-05
 * @version 1.0
 */
@Service
public class SysUserServiceImpl extends BaseServiceImpl<SysUserMapper, SysUser> implements SysUserService {


    @Override
    public SysUser getByUserName(String userName) {
        QueryWrapper<SysUser> query = new QueryWrapper<>();
        query.eq("userName", userName);
        return baseMapper.selectOne(query);
    }

}
