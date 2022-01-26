package signup;



import java.io.IOException;
import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class MemberService {
	
	public int joinMember(HttpServletRequest request, HttpServletResponse response) throws IOException {
		request.setCharacterEncoding("UTF-8");
		
		String Id = request.getParameter("Id");
		String Pw = request.getParameter("Pw");
		String Pw2 = request.getParameter("Pw2");
		String Name = request.getParameter("Name");
		String Birth = request.getParameter("Birth");
		String Sex = request.getParameter("Sex");
		String Email = request.getParameter("Email");
		String Agree1 = request.getParameter("Agree1");
		String Agree2 = request.getParameter("Agree2"); 
		// member테이블에 저장하는게 나을지 아님 처음 했던데로 Agree테이블에 따로 저장하는게 나을지??
		int statusCode = 400;
		
		// 파라미터 길이 제한 확인
		if((Id.length()<5 || Id.length()>20) || (Pw.length()<8 || Pw.length()>18) || (Email.length()>30) || Name.length()>17) {
			statusCode = 401; return statusCode;
		}
		
		if(!Pw.equals(Pw2)) { 
			// 비밀번호와 비밀번호 확인의 값은 같아야함.
			statusCode = 401; return statusCode;}
		if(!Email.contains("@naver.com") || Email.contains("@google.com")) { statusCode = 401; return statusCode;}
		
		MemberDto member = new MemberDto();
		member.setId(Id);
		member.setPw(Pw);
		member.setName(Name);
		member.setBirth(Birth);
		member.setSex(Sex.charAt(0));
		member.setEmail(Email);
		
		
		MemberDao dao = new MemberDao();
		boolean success = dao.insertMemebr(member);
		if(Agree1.equals("agree")) {
			member.setAgree1(Agree1);
			dao.insertAgree1(member);}
		if(Agree2.equals("agree")) {
			member.setAgree2(Agree2);
			dao.insertAgree2(member);
		}
		
		
		
		if(success) statusCode = HttpServletResponse.SC_OK;
		
		return statusCode;
		
	}
	

	public boolean checkId(String id) {
		MemberDao dao = new MemberDao();
		boolean result = dao.getIdCheckBoolean(id);
		
		return result;
	}
	
	public boolean checkEmail(String Email) {
		MemberDao dao = new MemberDao();
		boolean result = dao.getEmailCheckBoolean(Email);
		
		return result;
	}

}
