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
			yaz.println("<title>Kayýt Ýþlemi Baþarýlý</title>");
			yaz.println("</head>");
			yaz.println("<body>");
			yaz.println("<center>");
			if(result) {
				yaz.println("<h3>Kayýt olduðun için teþekkürler</h3>");
				yaz.println("<br/>");
				yaz.println("<p>Kullanýcý adý ve parolanýz ile giriþ yapmak için <a href='login.jsp'>týklayýnýz</a></p>");
			}else {
				yaz.println("<h3>Kayýt Baþarýsýz<h3/>");
				yaz.println("<br/>");
				yaz.println("<p>Tekrar denemek için <a href='register.jsp'>týklayýnýz</a></p>");
			}	
			yaz.println("</center>");
			yaz.println("</body>");
			yaz.println("</html>");	
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
}
