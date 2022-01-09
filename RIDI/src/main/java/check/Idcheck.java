package check;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.MemberService;

@WebServlet("/Idcheck")
public class Idcheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 아이디가 데이터 베이스에 있는지 확인
		request.setCharacterEncoding("UTF-8");
		MemberService service = new MemberService();
		String Id = request.getParameter("Id");
		boolean result = service.checkId(Id);
		// 아이디가 없으면 200, 아이디가 있으면 400전달
		if(!result)response.setStatus(200);
		else response.setStatus(400);
		
	}

}
