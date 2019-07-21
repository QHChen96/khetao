package com.khetao.auth.handler;

import com.google.common.net.MediaType;
import com.google.gson.Gson;
import com.khetao.base.BaseResult;
import com.khetao.enums.ResultCode;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.*;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

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
public class FailureHandler implements AuthenticationFailureHandler {

    static Map<Class<? extends AuthenticationException>, ResultCode> map = new HashMap<>();

    static {
        map.put(BadCredentialsException.class, ResultCode.CREDENTIALS_EXPIRED);
        map.put(LockedException.class, ResultCode.ACCOUNT_LOCKED);
        map.put(DisabledException.class, ResultCode.USER_DISABLED);
        map.put(CredentialsExpiredException.class, ResultCode.CREDENTIALS_EXPIRED);
        map.put(AccountExpiredException.class, ResultCode.ACCOUNT_EXPIRED);
    }

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        ResultCode resultCode = map.get(exception.getClass());
        if (null == resultCode) {
            resultCode = ResultCode.UNAUTHORIZED;
        }
        BaseResult baseResult = new BaseResult(resultCode);
        baseResult.setMessage(exception.getMessage());
        Gson gson = new Gson();
        String json = gson.toJson(baseResult);
        response.setStatus(HttpStatus.UNAUTHORIZED.value());
        response.setContentType(MediaType.JSON_UTF_8.subtype());
        response.getWriter().write(json);
        response.getWriter().flush();
    }

}
