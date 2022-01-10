package check;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.MemberService;

@WebServlet("/emailcheck")
public class Emailcheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 이메일이 데이터베이스에 있는지 확인
		request.setCharacterEncoding("UTF-8");
		String Email = request.getParameter("Email");
		
		MemberService service = new MemberService();
		boolean result = service.checkEmail(Email);
		
		// 이메일이 없으면 200, 아이디가 있으면 400전달
		if(!result)response.setStatus(200);
		else response.setStatus(400);
	}

}
