package controller.events;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.dao.GymDao;

@WebServlet("/events/design")
public class EventsDesignController extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse respsonse)
			throws ServletException, IOException {

		if(request.getSession().getAttribute("authUser") == null) {
			respsonse.sendRedirect(request.getContextPath()+"/login");
			return;
		}
		
		try {
			GymDao gymDao = new GymDao();
			List<String> types = gymDao.findDistinctType();
			System.out.println(types.size());
			request.setAttribute("types", types);
			request.getRequestDispatcher("/WEB-INF/view/events/design.jsp").forward(request, respsonse);
		} catch (Exception e) {
			request.getRequestDispatcher("/WEB-INF/view/events/error.jsp").forward(request, respsonse);
			e.printStackTrace();
		}

	}

}
