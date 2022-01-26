package alarm;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import signup.MemberService;

@WebServlet("/AlarmController")
public class AlarmController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		AlarmService service = new AlarmService();
		// 로그인되어 있는지 확인 -> 로그인 되어 있다면 세션에 있는 로그인 아이디 고유 번호 가져옴
		// 그 번호로 등록되어진 알림 목록들을 가져와서 보여줌
		HttpSession session = request.getSession();
		int loginIdNum=0;
		if(service.checkLoginStatus(request)) {
			// 로그인을 했는지 안했는지 확인해서   -> 했으면 true, 안했으면 false
			loginIdNum = (Integer) session.getAttribute("isLogin");
			// 세션의 isLogin속성의 값을 정수형으로 반환해서 저장
			service.getAlarms(loginIdNum);
			// 저장한 isLogin값을 통해서 로그인한 사람이 가진 알람들을 가져옴 (사진,제목,가격?) - 데이터 테이블 만들어야 함
			
		}else {
			response.sendRedirect("/ridibooks/login.html");
		}
		
	}

}
