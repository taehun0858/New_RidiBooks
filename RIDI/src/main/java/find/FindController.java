package find;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.MemberService;

@WebServlet("/FindController")
public class FindController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPOST(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String Email = request.getParameter("Email");
		
		MemberService service = new MemberService();
		
		String foundId = service.findIdByEmail(Email);
		request.setAttribute("Id", foundId);
		
		String Id = request.getParameter("Id");
		
		String foundPw = service.findPw(Id,Email);
		request.setAttribute("Pw", foundPw);
	}


}
