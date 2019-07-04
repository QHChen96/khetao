package com.khetao.auth.handler;

import com.alibaba.fastjson.JSON;
import com.khetao.base.BaseResult;
import com.khetao.dto.KhetaoUser;
import com.khetao.enums.ResultCode;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * <p>
 *  认证成功
 * </p>
 *
 * @author chenqinhao
 * @version 1.0
 * @email qhchen96@gmail.com
 * @since 2019-06-01
 */
public class TokenAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException {
        response.setHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_UTF8_VALUE);
        response.setStatus(HttpStatus.OK.value());
        KhetaoUser khetaoUser = (KhetaoUser) authentication.getPrincipal();
        String jwtToken = null;
        BaseResult result = new BaseResult(ResultCode.SUCCESS, jwtToken);
        response.getWriter().write(JSON.toJSONString(result));
        response.getWriter().flush();
    }
}
