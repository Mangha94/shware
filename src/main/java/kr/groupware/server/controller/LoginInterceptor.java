package kr.groupware.server.controller;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.groupware.lib.StrLib;

public class LoginInterceptor extends HandlerInterceptorAdapter
{
	@Override
	public boolean preHandle (HttpServletRequest request, HttpServletResponse response, Object handler)
		throws Exception
	{
		boolean b = super.preHandle (request, response, handler);

		HttpSession session = request.getSession ();

		String memberId = (String) session.getAttribute ("memberId");

		if (StrLib.isEmptyStr (memberId))
		{
			response.sendRedirect ("/login.do");

			// 문제
			return false;
		}

		return b;
	}
}
