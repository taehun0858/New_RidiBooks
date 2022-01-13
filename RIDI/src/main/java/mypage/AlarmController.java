package mypage;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.MemberService;

@WebServlet("/AlarmController")
public class AlarmController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		MemberService service = new MemberService();
		// 로그인되어 있는지 확인 -> 로그인 되어 있다면 세션에 있는 로그인 아이디 고유 번호 가져옴
		// 그 번호로 등록되어진 알림 목록 가져와서 보여줌
	}

}
