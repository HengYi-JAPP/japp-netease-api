package com.hengyi.japp.netease.interfaces.servlet;

import com.github.ixtf.japp.core.exception.JAuthenticationException;
import lombok.SneakyThrows;
import org.jasig.cas.client.util.AssertionHolder;
import org.jasig.cas.client.validation.Assertion;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.IOException;
import java.security.Principal;
import java.util.Optional;

/**
 * Created by jzb on 17-3-13.
 */
public class PrincipalFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        chain.doFilter(new HttpServletRequestWrapper((HttpServletRequest) request) {
            @SneakyThrows
            @Override
            public Principal getUserPrincipal() {
                Assertion assertion = AssertionHolder.getAssertion();
                return Optional.ofNullable(assertion)
                        .map(Assertion::getPrincipal)
                        .orElseThrow(() -> new JAuthenticationException());
            }
        }, response);
    }

    @Override
    public void destroy() {
    }

}

