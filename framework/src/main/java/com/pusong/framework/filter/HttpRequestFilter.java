package com.pusong.framework.filter;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Enumeration;
import java.util.Map;

public class HttpRequestFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        System.out.println(request.getMethod() + " " + request.getRequestURL());


        Enumeration<String> headers = request.getHeaderNames();
        while (headers.hasMoreElements()) {
            String header = headers.nextElement();
            System.out.println(header);

            Enumeration<String> h = request.getHeaders(header);
            while (h.hasMoreElements()) {
                System.out.println(h.nextElement());

            }
        }

        System.out.println(request.getQueryString());

        Map<String, String[]> params = request.getParameterMap();
        for (String key : params.keySet()) {
            System.out.println(key + params.get(key)[0]);
        }

        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            System.out.println(cookie);
        }

        BufferedReader bodyReader = new BufferedReader(new InputStreamReader(request.getInputStream()));
        StringBuffer body = new StringBuffer();
        String data;
        while ((data = bodyReader.readLine()) != null) {
            body.append(data);
            System.out.println(data);
        }
        bodyReader.close();

        System.out.println(request.getRemoteAddr());

        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
    }
}
