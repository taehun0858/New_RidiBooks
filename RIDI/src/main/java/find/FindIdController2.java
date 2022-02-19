package find;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/find/id2")
// 입력한 이메일 정보를 통해 아이디를 찾는다. 찾은 아이디를 에이잭스를 통해 받을 수 있게 한다.
public class FindIdController2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String Email = request.getParameter("Email");
		FindService service = new FindService();
		PrintWriter writer = response.getWriter();
		response.setContentType("text/html;charset=UTF-8");
		String foundId = service.findIdByEmail(Email);	
		foundId = foundId.substring(0, 2)+foundId.substring(2).replaceAll(".","*");
		writer.print(foundId);
		response.setStatus(200);
	}


} 
