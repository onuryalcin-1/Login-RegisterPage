package com.bilgeadam.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bilgeadam.entity.User;
import com.bilgeadam.service.RegisterService;

@WebServlet("/registerServlet")
public class RegisterControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html; charset=utf-8");
		PrintWriter yaz = resp.getWriter();
		
		String firstName = req.getParameter("firstName");
		String lastName = req.getParameter("lastName");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		String userId = req.getParameter("userId");
		
		User user = new User(userId, firstName, lastName, email, password);
		
		try {
			RegisterService registerService = new RegisterService();
			boolean result = registerService.register(user);
			yaz.println("<!DOCTYPE html>");
			yaz.println("<html>");
			yaz.println("<head>");
			yaz.println("<title>Kay�t ��lemi Ba�ar�l�</title>");
			yaz.println("</head>");
			yaz.println("<body>");
			yaz.println("<center>");
			if(result) {
				yaz.println("<h3>Kay�t oldu�un i�in te�ekk�rler</h3>");
				yaz.println("<br/>");
				yaz.println("<p>Kullan�c� ad� ve parolan�z ile giri� yapmak i�in <a href='login.jsp'>t�klay�n�z</a></p>");
			}else {
				yaz.println("<h3>Kay�t Ba�ar�s�z<h3/>");
				yaz.println("<br/>");
				yaz.println("<p>Tekrar denemek i�in <a href='register.jsp'>t�klay�n�z</a></p>");
			}	
			yaz.println("</center>");
			yaz.println("</body>");
			yaz.println("</html>");	
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
}
