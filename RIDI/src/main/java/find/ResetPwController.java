package find;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/resetPw")
public class ResetPwController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String usedPw = request.getParameter("usedPw");
		String Email = request.getParameter("Email");
		String Id = request.getParameter("Id");
		String Pw = request.getParameter("Pw");
		PwDto member = new PwDto();
		member.setEmail(Email);
		member.setId(Id);
		member.setPw(usedPw);
		FindService service = new FindService();
		boolean success = service.resetPw(member,Pw);
		if(success==true) {
			response.setStatus(200);
		}else {
			response.setStatus(400);
		}
	}

}
