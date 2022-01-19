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
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String type = request.getParameter("findtype");
		String Email = request.getParameter("Email");
		String Id = request.getParameter("Id");
		
		MemberService service = new MemberService();
		
		String foundId=null;
		String foundPw = null;
		if(type.equals("Email")) {
			foundId = service.findIdByEmail(Email);
		}else if(type.equals("Email,Id")){
			foundPw = service.findPw(Id,Email);
		}		
		
	}


}
