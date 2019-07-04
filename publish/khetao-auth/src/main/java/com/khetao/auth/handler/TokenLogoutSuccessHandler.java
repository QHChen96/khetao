package com.khetao.auth.handler;

import com.alibaba.fastjson.JSON;
import com.khetao.base.BaseResult;
import com.khetao.enums.ResultCode;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * <p>
 *  登出
 * </p>
 *
 * @author chenqinhao
 * @version 1.0
 * @email qhchen96@gmail.com
 * @since 2019-06-01
 */
public class TokenLogoutSuccessHandler implements LogoutSuccessHandler {

    @Override
    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException {
        response.setHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_UTF8_VALUE);
        response.setStatus(HttpStatus.OK.value());
        BaseResult result = new BaseResult(ResultCode.SUCCESS);
        response.getWriter().write(JSON.toJSONString(result));
        response.getWriter().flush();
    }

}
