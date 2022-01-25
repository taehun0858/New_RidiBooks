package find;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import signup.MemberService;

@WebServlet("/find")
public class FindController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		// 이메일을 통해 무언가를 찾는다면 아이디 찾기 가 되고
		// 이메일과 아이디를 통해 무언가를 찾는다면 비밀번호 찾기가 된다.
		String type = request.getParameter("findtype");
		String Email = request.getParameter("Email");
		String Id = request.getParameter("Id");
		String Pw = request.getParameter("Pw");
		FindService service = new FindService();
		response.setContentType("text/html;charset=UTF-8");
				
		String foundId=null;
		String foundPw = null;
		if(type.equals("email")) {
			foundId = service.findIdByEmail(Email);	
			
			PrintWriter writer = response.getWriter();
			
			writer.print(foundId);
			
		}else if(type.equals("email,text")){
			foundPw = service.resetPw(Id,Email,Pw);
		}else if(type.isEmpty() || type==null) {		
			response.setStatus(401);// 타입의 형식을 전달해주지 않는다면 401에러 발생
		}
		
	}


}
