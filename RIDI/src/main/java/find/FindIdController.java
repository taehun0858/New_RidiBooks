package find;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/find/id1")
// 입력한 이메일 정보를 통해 아이디를 찾는다. 찾은 아이디를 에이잭스를 통해 받을 수 있게 한다.
public class FindIdController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String Email = request.getParameter("Email");
		boolean email_check = Pattern.matches("\\w+@\\w+\\.\\w+(\\.\\w+)?", Email);
		if(email_check==false) {
			response.setStatus(403);
			// 이메일형식에 맞지 않으면 403코드 
		}
		
		FindService service = new FindService();
		String foundId = service.findIdByEmail(Email);	
		if(foundId==null) {
			response.setStatus(404);
			// 일치하는 정보를 찾을 수 없을때 404코드
		}else {
			PrintWriter writer = response.getWriter();
			response.setContentType("text/html;charset=UTF-8");
			writer.print(Email);
			response.setStatus(200);
		}
		
	}


}
