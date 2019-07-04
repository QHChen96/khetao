package com.khetao.auth.handler;

import com.alibaba.fastjson.JSON;
import com.khetao.base.BaseResult;
import com.khetao.enums.ResultCode;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * <p>
 *  未经过身份验证的用户试图范围受保护的资源
 *  http 状态码为401
 *  响应消息 code为401
 * </p>
 *
 * @author chenqinhao
 * @version 1.0
 * @email qhchen96@gmail.com
 * @since 2019-06-01
 */
public class UnauthorizedEntryPoint implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException {
        // TODO 根据情况判断是否需要失败回调
        response.setHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_UTF8_VALUE);
        response.setStatus(HttpStatus.UNAUTHORIZED.value());
        BaseResult result = new BaseResult(ResultCode.UNAUTHORIZED);
        response.getWriter().write(JSON.toJSONString(result));
        response.getWriter().flush();
    }
}
