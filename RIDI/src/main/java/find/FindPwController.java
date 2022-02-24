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
		
//		PrintWriter out = response.getWriter();
//		
//		String result = "{\"Id\":\""+member.getId()+"\","
//				+ "\"Email\"=\""+member.getEmail()+"\","
//				+ "\"id\"=\""+member.getPw()+"\","
//				+ "}";
//		
//		out.print(result);
		// 위 코드는 에이잭스를 사용할때 대비한 코드이다.
		request.setAttribute("memberPw", member);
		service.sendEmail(member);
		
		RequestDispatcher rd = request.getRequestDispatcher("resetPassword2.jsp");
		rd.forward(request, response);
		
		
	}

}
