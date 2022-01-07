package member;



import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		String Agree = request.getParameter("Agree"); 
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
		// LocalDateTime M_date = LocalDateTime.now();
		// member.setM_Date(M_date); 
		// 회원가입한 날짜와 시간 인데 시간이 안들어감(형식이 Date이니까) 
		
		
		MemberDao dao = new MemberDao();
		boolean success = dao.insertMemebr(member);
		
		
		if(success) statusCode = HttpServletResponse.SC_OK;
		
		return statusCode;
		
	}
	
	public int login(HttpServletRequest request, HttpServletResponse response) throws IOException {
		request.setCharacterEncoding("UTF-8");
		// 로그인을 해서 성공하면 200코드를, 해당정보가 없다면 404, 파라미터가 다 전달되지 않았다면 400, 파라미터 값이 잘못되었다면 401
		String Id = request.getParameter("Id");
		String Pw = request.getParameter("Pw");
		int statusCode;
		
		if(Id==null || Id.isEmpty()||Pw.isEmpty()||Pw==null) {statusCode = 400;return statusCode;}
		// 아이디나 비밀번호 중 하나라도 빠졌다면 400 전달
		if(Id.length()>20 || Id.length()<5 || Pw.length()<8) {statusCode = 401;return statusCode;}
		// 아이디의 길이가 5~20 사이가 아니거나 비밀번호의 길이가 8보다 작다면 401전달
		
		MemberDao dao = new MemberDao();
		boolean success = dao.loginMemebr(Id,Pw);
		if(success) {statusCode = 200;}
		// 로그인 성공시(입력한 아이디와 비밀번호에 맞는 정보가 있을 때) 200코드 전달
		else {statusCode = 404;}
		// 로그인 실패시(입력한 아이디와 비밀번호에 맞는 정보가 없을 때) 404코드 전달
		
		return statusCode;
	}
	
	public int getLoginIdNum(HttpServletRequest request, HttpServletResponse response) throws IOException {
		request.setCharacterEncoding("UTF-8");
		
		String Id = request.getParameter("Id");
		
		MemberDao dao = new MemberDao();
		int loginIdNum = dao.loginIdNum(Id);
		
		return loginIdNum;
	}
}
