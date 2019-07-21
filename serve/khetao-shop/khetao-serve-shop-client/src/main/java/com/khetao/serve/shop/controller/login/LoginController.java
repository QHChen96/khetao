package com.khetao.serve.shop.controller.login;

import com.khetao.base.BaseController;
import com.khetao.base.BaseResult;
import com.khetao.base.service.KhetaoUserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
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
@AllArgsConstructor
public class LoginController extends BaseController {

    private final KhetaoUserService userService;


    @GetMapping("/auth/login")
    public BaseResult login(String username) {
        return success(username);
    }

    @GetMapping("/login")
    public BaseResult home() {
        return success();
    }

}
