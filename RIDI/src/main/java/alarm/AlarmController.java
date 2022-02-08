package alarm;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/alarmcontroller")
public class AlarmController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int IdNum = Integer.parseInt((String) request.getSession().getAttribute("isLogin"));
		String active = request.getParameter("active");
		int alarmNum = Integer.parseInt(request.getParameter("alarmNum"));
		AlarmService service = new AlarmService();
		boolean success = false;
		if (IdNum == 0) {
			response.setStatus(404);
		} // 로그인이 안되어있다면 404상태코드 저장

		if (active.equals("show")) {
			// 알람 메세지들을 전달해주는 동작
			List<AlarmDto> alarms = service.showAlarms(IdNum);
			if (alarms != null) {
				response.setStatus(200); // 알람에 메세지들이 하나라도 전달됬으면 200상태코드
				request.setAttribute("messages", alarms);
			} else if (alarms == null) {
				response.setStatus(201);
			} // 알람에 메세지들이 하나도 없으면 201상태코드
		} 
		else if (active.equals("change")) {
			success = service.changeAlarm(IdNum, alarmNum);
			if (success == false) response.setStatus(401);
		} 

	}
}
