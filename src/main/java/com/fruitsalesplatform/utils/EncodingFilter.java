package com.fruitsalesplatform.utils;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author dukunpeng
 * @date 2018/8/19 15:04
 */
public class EncodingFilter implements Filter {

//   默认值
    private String encoding = "UTF-8";

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        if(filterConfig.getInitParameter("ENCODING")!=null){
            encoding = filterConfig.getInitParameter("ENCODING");
        }
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        servletRequest.setCharacterEncoding(encoding);
        servletResponse.setCharacterEncoding(encoding);
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {
        encoding = null;
    }
}
