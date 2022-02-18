package login;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/member/logIn")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	// 로그아웃
	protected void doGET(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.invalidate();
	}
	
	// 로그인 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		LoginService service = new LoginService();
		int statuscode = service.login(request, response);
		response.setStatus(statuscode);
//		response.setStatus(200);
		// 로그인 실행시 결과(상태코드)를 상태코드에 전달
		int loginId;
		HttpSession session = request.getSession();
		if(statuscode==200) {
			// 로그인을 성공했을 때(상태코드가 200일때) 로그인한 아이디의 고유 번호를 전달받아 세션의 isLogin속성에 저장
			// 세션은 5분동안 아무런 행동을 하지 않는다면 없어짐
			loginId=service.getLoginIdNum(request, response);
			session.setAttribute("isLogin", loginId);
			session.setMaxInactiveInterval(60*5);
		}
		
		
		
		
	}

}
