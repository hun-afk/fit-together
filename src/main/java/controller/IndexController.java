package controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/index")
public class IndexController extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (request.getSession().getAttribute("authUser") == null) { // 로그인 상황에 맞춰 다른 화면으로 보내기
			request.getRequestDispatcher("/WEB-INF/view/index.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("/WEB-INF/view/logon-index.jsp").forward(request, response);
		}
	}
}