package kr.groupware.server.controller;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class SecurityInterceptor extends HandlerInterceptorAdapter
{
    @Override
    public boolean preHandle (HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception
    {
        boolean b = super.preHandle (request, response, handler);

        HttpSession session = request.getSession ();

        int securityRating = (int) session.getAttribute ("securityRating");

        if (securityRating<1)
        {
            response.sendRedirect ("/index.do");

            return false;
        }

        return b;
    }
}
