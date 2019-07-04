package com.khetao.auth.handler;

import com.alibaba.fastjson.JSON;
import com.khetao.base.BaseResult;
import com.khetao.enums.ResultCode;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * <p>
 *  拒绝访问
 *  已经通过身份验证 试图范围受保护的资源
 *  http 状态码 200
 *  响应消息 code 403
 * </p>
 *
 * @author chenqinhao
 * @version 1.0
 * @email qhchen96@gmail.com
 * @since 2019-05-31
 */
public class TokenAccessDeniedHandler implements AccessDeniedHandler {

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
        response.setHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_UTF8_VALUE);
        response.setStatus(HttpStatus.OK.value());
        BaseResult result = new BaseResult(ResultCode.FORBIDDEN);
        response.getWriter().write(JSON.toJSONString(result));
        response.getWriter().flush();
    }
}
