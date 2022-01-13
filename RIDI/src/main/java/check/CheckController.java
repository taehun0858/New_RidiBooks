package check;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.MemberService;

@WebServlet("/check")
public class CheckController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 프론트에서 파라미터를 전달할 때 type을 같이 전달해줘서 type이 email이냐 id이냐 에 따라서 다른 메서드를 실행함
		request.setCharacterEncoding("UTF-8");
		
		MemberService service = new MemberService();
		
		String Type = request.getContentType();
		// 전달되는 컨텐츠의 타입이 뭔지 받아옴
		
		String Id = request.getParameter("Id");		
		String Email = request.getParameter("Email");
		boolean EmailCheck;
		boolean Idcheck;
		
		if(Type.equals(Email)) {		
			EmailCheck = service.checkEmail(Email);			
			// 이메일이 없으면 200, 아이디가 있으면 400전달
			if(!EmailCheck)response.setStatus(200);
			else response.setStatus(400);
		}else {
			Idcheck = service.checkId(Id);
			// 아이디가 없으면 200, 아이디가 있으면 400전달
			if(!Idcheck)response.setStatus(200);
			else response.setStatus(400);
		}
	}


}
