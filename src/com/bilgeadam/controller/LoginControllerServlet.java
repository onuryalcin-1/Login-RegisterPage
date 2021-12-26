package com.bilgeadam.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bilgeadam.entity.User;
import com.bilgeadam.service.LoginService;

@WebServlet("/loginServlet")
public class LoginControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String userId = req.getParameter("userId");
		String password = req.getParameter("password");
		
		LoginService loginService = new LoginService();
		boolean result = loginService.authentication(userId,password);
		
		User user = loginService.getUserById(userId);
		
		if(result) {
			req.getSession().setAttribute("user", user);
			resp.sendRedirect("index.jsp"); // login iþlemi baþarýlýysa anasayfaya yönlendirir
		}else {
			resp.sendRedirect("error.jsp");
		}
	}

}
