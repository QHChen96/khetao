package com.khetao.auth.handler;

import com.google.common.net.MediaType;
import com.google.gson.Gson;
import com.khetao.auth.service.KhetaoUserDetails;
import com.khetao.auth.util.JwtUtil;
import com.khetao.base.BaseResult;
import com.khetao.base.service.KhetaoUserService;
import com.khetao.dto.KhetaoUser;
import com.khetao.enums.ResultCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

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
@Component
public class SuccessHandler implements AuthenticationSuccessHandler {

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private KhetaoUserService khetaoUserService;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        // 生成token
        KhetaoUserDetails details = (KhetaoUserDetails)authentication.getPrincipal();
        KhetaoUser khetaoUser = details.getKhetaoUser();
        // 创建token
        String token = jwtUtil.createJwt(khetaoUser);
        // 存储token

        BaseResult baseResult = new BaseResult(ResultCode.SUCCESS, token);
        Gson gson = new Gson();
        String json = gson.toJson(baseResult);
        response.setContentType(MediaType.JSON_UTF_8.subtype());
        response.getWriter().write(json);
        response.getWriter().flush();
    }
}
