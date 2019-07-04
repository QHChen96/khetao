package com.khetao.auth.handler;

import com.alibaba.fastjson.JSON;
import com.khetao.base.BaseResult;
import com.khetao.enums.ResultCode;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * <p>
 *  身份验证验证失败
 *  http 状态码为401
 *  响应消息 code为401
 * </p>
 *
 * @author chenqinhao
 * @version 1.0
 * @email qhchen96@gmail.com
 * @since 2019-06-01
 */
public class TokenAuthenticationFailureHandler implements AuthenticationFailureHandler {

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        response.setHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_UTF8_VALUE);
        response.setStatus(HttpStatus.UNAUTHORIZED.value());
        BaseResult result = new BaseResult(ResultCode.UNAUTHORIZED);
        response.getWriter().write(JSON.toJSONString(result));
        response.getWriter().flush();
    }
}
