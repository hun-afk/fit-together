package controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/logout")
public class LogoutController extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String method = request.getMethod();
		if (method.equals("GET")) {
			request.getRequestDispatcher("/WEB-INF/view/logout-decide.jsp");
		} else {
//			request.setAttribute("auth", false);
			request.getSession().removeAttribute("authUser");
			response.sendRedirect(request.getContextPath() + "/index");
		}
	}
}