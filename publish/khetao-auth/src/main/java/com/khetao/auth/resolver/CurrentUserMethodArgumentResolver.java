package com.khetao.auth.resolver;

import com.google.common.net.HttpHeaders;
import com.khetao.auth.annotation.CurrentUserId;
import com.khetao.auth.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

/**
 * <p>
 *
 * </p>
 *
 * @author chenqinhao
 * @version 1.0
 * @email qhchen96@gmail.com
 * @since 2019-07-22
 */
@Component
public class CurrentUserMethodArgumentResolver implements HandlerMethodArgumentResolver {

    @Autowired
    private JwtUtil jwtUtil;

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        if (parameter.getParameterType().isAssignableFrom(Long.class) && parameter.hasParameterAnnotation(CurrentUserId.class)) {
            return true;
        }
        return false;
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        CurrentUserId currentUserId = parameter.getParameterAnnotation(CurrentUserId.class);
        Object object = webRequest.getAttribute(currentUserId.value(), NativeWebRequest.SCOPE_REQUEST);
        if (null == object) {
            String authorization = webRequest.getHeader(HttpHeaders.AUTHORIZATION);
            if (!StringUtils.isEmpty(authorization)) {
                String token = authorization.replace("Bearer ", "");
                return jwtUtil.getUserId(token);
            }
            return null;
        }
        return object;
    }
}
