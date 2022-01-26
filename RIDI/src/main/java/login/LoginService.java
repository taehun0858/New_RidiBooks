package login;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class LoginService {

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
		
		LoginDao dao = new LoginDao();
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
		
		LoginDao dao = new LoginDao();
		int loginIdNum = dao.getLoginIdNum(Id);
		
		return loginIdNum;
	}
}
