package controller.events;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.dao.EventDao;
import model.dao.GymDao;
import model.dao.ParticipantDao;
import model.vo.Event;
import model.vo.Participant;
import model.vo.User;

@WebServlet("/events/*")
public class EventsViewController extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// System.out.println("/events/*");
		// int id = Integer.parseInt(request.getParameter("id")); 1번방식
		try {
			String uri = request.getRequestURI();
			// System.out.println(uri);
			int id = Integer.parseInt(uri.substring(uri.lastIndexOf("/") + 1)); // 2번방식
			// System.out.println(id);
			EventDao eventDao = new EventDao();
			Event event = eventDao.findById(id);
			GymDao gymDao = new GymDao();

			request.setAttribute("gym", gymDao.findById(event.getGymId()));
			request.setAttribute("event", event);
			
			ParticipantDao participantDao = new ParticipantDao();
			List<Participant> participants = participantDao.findByEventId(id);
			List<String> userIds = new ArrayList<>();
			for (Participant one : participants) {
				userIds.add(one.getUserId()); //반복문 돌면서 참가자 아이디만 추출
			}
			User authUser = (User)request.getSession().getAttribute("authUser");
			
			if(authUser != null && userIds.contains(authUser.getId())) {
				request.setAttribute("flag", true);
			} else {
				request.setAttribute("flag", false);
			}
			
			String tab = request.getParameter("tab");
			if(tab == null) {
				request.setAttribute("participants", participants);
				request.setAttribute("psize", participants.size());
				request.getRequestDispatcher("/WEB-INF/view/events/view-default.jsp").forward(request, response);
			} else {
				request.getRequestDispatcher("/WEB-INF/view/events/view-comment.jsp").forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.getRequestDispatcher("/WEB-INF/view/events/error.jsp").forward(request, response);
		}

	}

}