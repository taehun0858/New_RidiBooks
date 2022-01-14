package mypage;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.MemberService;

@WebServlet("/CartController")
public class CartController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		MemberService service = new MemberService();
		if(session.getAttribute("isLogin")==null || Integer.parseInt((String) session.getAttribute("isLogin"))==0) {
			// 세션의 isLogin홋성 값을 가져옴 그 속성값은 결국 로그인한 아이디의 아이디 고유번호일것임, isLogin이 비었거나 0이라면
			
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
