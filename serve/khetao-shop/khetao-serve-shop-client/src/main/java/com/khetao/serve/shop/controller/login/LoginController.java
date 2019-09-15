package com.khetao.serve.shop.controller.login;

import com.khetao.base.BaseController;
import com.khetao.base.service.KhetaoUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

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
@RestController
public class LoginController extends BaseController {

    @Autowired
    private KhetaoUserService userService;




}
