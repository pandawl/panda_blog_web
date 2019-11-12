package com.panda.filter;/*
package com.wang.server.filter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Component
@WebFilter(filterName = "SessionFilter",urlPatterns = "/*")
public class SessionFilter implements Filter {
   */
/* @Autowired
    private RedisTemplate redisTemplate;
    private static final List<String> ingorePath = Arrays.asList(
            "/server/customer/login");


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String url =request.getRequestURI();
        if (ingorePath.contains(url)) {
            chain.doFilter(request, response);
        } *//*
*/
/*else {
            CustomerReg info = null;
            String token = request.getParameter("token");

            if (token != null) {
                Object json = redisTemplate.opsForValue().get(token);
                if (json != null) {
                    info = new GsonBuilder()
                            .setDateFormat("yyyy-MM-dd HH:mm:ss")
                            .create().fromJson(json.toString(), CustomerReg.class);
                }
            }
            if (info == null) {
               *//*
*/
/**//*
*/
/* response.setCharacterEncoding("utf-8");
                response.setContentType("application/json; charset=utf-8");
                PrintWriter writer = response.getWriter();
                String data = ResultUtils.generateResultStr(ResultCode.SESSION_TIME_OUT, "", "");
                writer.write(data);
                writer.flush();
                writer.close();
                return;*//*
*/
/**//*
*/
/*
            } else {
                *//*
*/
/**//*
*/
/*String[] urls = url.split("/");
                String model_url = null;
                if (urls.length >= 3) {
                    model_url = urls[urls.length - 2];
                }*//*
*/
/**//*
*/
/*
                request.setAttribute(Constants.USER_LOGIN_INFO, info);
            *//*
*/
/**//*
*/
/*    request.setAttribute(Constants.MODEL_URL, model_url);*//*
*/
/**//*
*/
/*

            }
            chain.doFilter(request, response);*//*
*/
/*
*//*



    @Override
    public void destroy() {

    }
}
*/
