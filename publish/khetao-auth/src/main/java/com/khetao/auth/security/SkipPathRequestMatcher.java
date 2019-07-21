package com.khetao.auth.security;

import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.OrRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.util.Assert;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 *  跳过路径
 * </p>
 *
 * @author chenqinhao
 * @version 1.0
 * @email qhchen96@gmail.com
 * @since 2019-07-21
 */
public class SkipPathRequestMatcher implements RequestMatcher {

    private OrRequestMatcher matcher;
    private RequestMatcher processingMatcher;

    public SkipPathRequestMatcher(List<String> pathsToSkip, String processingPath) {
        Assert.notNull(pathsToSkip, "path is not blank!");
        List<RequestMatcher> matchers =  pathsToSkip
                .stream()
                .map(path -> new AntPathRequestMatcher(path))
                .collect(Collectors.toList());
        matcher = new OrRequestMatcher(matchers);
        processingMatcher = new AntPathRequestMatcher(processingPath);
    }

    @Override
    public boolean matches(HttpServletRequest request) {
        if (matcher.matches(request)) {
            return false;
        }
        return processingMatcher.matches(request) ? true : false;
    }
}
