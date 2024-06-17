package controller;

import java.io.IOException;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.dao.UserDao;
import model.vo.User;

@WebServlet("/signup-handle")
public class SignupHandleController extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		int birth = Integer.parseInt(request.getParameter("birth"));
		String gender = request.getParameter("gender");
		String[] interests = request.getParameterValues("interest");
		if (interests == null) {
			interests = new String[0];
		}

		User one = new User(id, password, name, gender, birth, email, String.join(",", interests));
		
		UserDao userDao = new UserDao();
		boolean result = false;

		try {

			User exist = userDao.findById(id);

			if (exist == null) {
				result = userDao.save(one);
			}
				if (result) {
					request.getSession().setAttribute("authUser", one);
					response.sendRedirect(request.getContextPath() + "/index");
				} else {
					response.sendRedirect(request.getContextPath() + "/signup?error");
				}
		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
