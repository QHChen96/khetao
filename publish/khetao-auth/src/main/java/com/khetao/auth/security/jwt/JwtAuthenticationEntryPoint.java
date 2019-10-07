package com.khetao.auth.security.jwt;

import com.google.common.net.MediaType;
import com.google.gson.Gson;
import com.khetao.base.BaseResult;
import com.khetao.base.enums.ResultCode;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * <p>
 *  jwt 验证端点
 * </p>
 *
 * @author chenqinhao
 * @version 1.0
 * @email qhchen96@gmail.com
 * @since 2019-07-20
 */
@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint {


    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        BaseResult baseResult = new BaseResult(ResultCode.UNAUTHORIZED);
        Gson gson = new Gson();
        String json = gson.toJson(baseResult);
        response.setStatus(HttpStatus.UNAUTHORIZED.value());
        response.setContentType(MediaType.JSON_UTF_8.subtype());
        response.getWriter().write(json);
        response.getWriter().flush();
    }
}
