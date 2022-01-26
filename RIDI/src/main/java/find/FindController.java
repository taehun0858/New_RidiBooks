package find;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/find")
public class FindController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PwDto PwDto = (PwDto) request.getAttribute("PwDto");
		// 바꿀 비밀번호 정보를 가진 객체
		String Pw = request.getParameter("Pw");
		// 바꾸려고 입력한 비밀번호
		FindService service = new FindService();
		
		if(Pw==null || PwDto==null || Pw.isEmpty()) {
			response.setStatus(400);
			// 비밀번호나 바꿀비밀번호가 하나라도 없을시 400 상태코드 저장
		}else {
			boolean success = service.resetPw(Pw, PwDto);
			if(success==true) {response.setStatus(200);}
			else {response.setStatus(404);}
		}
	}



	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		// 이메일을 통해 무언가를 찾는다면 아이디 찾기 가 되고
		// 이메일과 아이디를 통해 무언가를 찾는다면 비밀번호 찾기가 된다.
		String type = request.getParameter("findtype");
		String Email = request.getParameter("Email");
		String Id = request.getParameter("Id");
		FindService service = new FindService();
		PrintWriter writer = response.getWriter();
		response.setContentType("text/html;charset=UTF-8");
				
		if(type==null || Email==null || Id==null) {
			response.setStatus(404);
			// 한개라도 전달 해주지 않을시 404코드 전달
		}
		
		String foundId=null;
		PwDto foundPw;
		if(type.equals("findId")) {
			foundId = service.findIdByEmail(Email);				
			writer.print(foundId);
			
		}else if(type.equals("resetPw")){
			foundPw = service.findPw(Id,Email);
			if(foundPw!=null) {
				writer.print(foundPw);
				// 변경해줄 비밀번호를 찾아옴
				response.setStatus(200);
				// 비밀번호 정보를 찾았으면 200을 전달해줌}
			}else {
				response.setStatus(400);
				// 비밀번호 정보를 찾지 못했다면 400
			}
			
			
		}
		
	}


}
