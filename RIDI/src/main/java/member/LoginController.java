package member;

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
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		MemberService service = new MemberService();
		int loginId = service.login(request, response);
		// 로그인 성공시 상태코드 200 전달
		if(loginId!=0) response.setStatus(200);
		
		// 로그인 성공시 세션의 isLogin속성에 아이디 번호 전달
		HttpSession session = request.getSession();
		if(response.getStatus()==200 && session.getAttribute("isLogin")==null) session.setAttribute("isLogin", loginId);
		
		
		
	}

}
