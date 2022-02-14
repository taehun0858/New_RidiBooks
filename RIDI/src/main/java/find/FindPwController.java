package find;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/findPw")
public class FindPwController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String Email = request.getParameter("Email");
		String Id = request.getParameter("Id");
		PwDto member = new PwDto();
		
		FindService service = new FindService();
		
		
		member.setEmail(Email);
		member.setId(Id);		
		String Pw =service.findPw(member);
		member.setPw(Pw);
		
		request.setAttribute("memberPw", member);
		
		RequestDispatcher rd = request.getRequestDispatcher("findIdTest.jsp");
		rd.forward(request, response);
	}

}
