package member;



import java.io.IOException;

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
	
	public int login(HttpServletRequest request, HttpServletResponse response) throws IOException {
		request.setCharacterEncoding("UTF-8");
		// 로그인을 해서 성공하면 200코드를, 해당정보가 없다면 404, 파라미터가 다 전달되지 않았다면 400, 파라미터 값이 잘못되었다면 401 전달
		String Id = request.getParameter("ID");
		String Pw = request.getParameter("PW");
		int statusCode;
		
		if(Id==null || Id.isEmpty()||Pw.isEmpty()||Pw==null) {statusCode = 400;return statusCode;}
		// 아이디나 비밀번호 중 하나라도 빠졌다면 400 전달
		if(Id.length()>20 || Id.length()<5 || Pw.length()<8) {statusCode = 401;return statusCode;}
		// 아이디의 길이가 5~20 사이가 아니거나 비밀번호의 길이가 8보다 작다면 401전달
		
		MemberDao dao = new MemberDao();
		int loginmemberNum = dao.getLoginMemebr(Id,Pw);
		if(loginmemberNum != 0) {
			statusCode = 200;
			dao.loginDateUpdate(Id);
		}
		// 로그인 성공시(입력한 아이디와 비밀번호에 맞는 정보가 있을 때) 200코드 전달, 최근 로그인 날짜 지금 날짜로 변경
		else {statusCode = 404;}
		// 로그인 실패시(입력한 아이디와 비밀번호에 맞는 정보가 없을 때) 404코드 전달
		
		return statusCode;
	}
	
	public int getLoginIdNum(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// 로그인한 아이디의 고유번호를 전달
		request.setCharacterEncoding("UTF-8");
		
		String Id = request.getParameter("Id");
		
		MemberDao dao = new MemberDao();
		int loginIdNum = dao.getLoginIdNum(Id);
		
		return loginIdNum;
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

	public String findIdByEmail(String email) {
		MemberDao dao = new MemberDao();
		String foundId = dao.findIdByEmail(email);
		return foundId;
	}

	public String findPw(String id, String email) {
		MemberDao dao = new MemberDao();
		String foundPw = dao.findPw(id,email);
		return foundPw;
	}

	public void showAlarms(int loginIdNum) {
		// 로그인 아이디의 고유 번호를 받아왔음. -> 다오로 그 고유번호에 해당하는 아이디의 알람들을 보여줄 수 있어야함
		MemberDao dao = new MemberDao();
		
	}

}
