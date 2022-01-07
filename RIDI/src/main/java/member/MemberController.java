package member;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/member/controller")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Get 동작 - 검색?
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// POST동작 회원가입,로그인
		
		// 
		request.setCharacterEncoding("UTF-8");
		MemberService service = new MemberService();
		int statusCode = service.joinMember(request, response);		
		response.setStatus(statusCode);
		// 회원가입기능 실행시 결과(상태코드)를 전달
		// 성공적으로 회원가입시 200코드 전달됨. 
		
		if(statusCode == HttpServletResponse.SC_OK) {
			// 상태코드가 200이면 다음 페이지로 이동
			response.sendRedirect("/ridibooks/login.html"); // 로그인 컨트롤러에서 로그인 자동으로 실행
		}
	}

	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Put 동작 - 회원 상태 변경(탈퇴)
	}
	
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Delete 동작 - 생각 중인것 없음
	}
}
