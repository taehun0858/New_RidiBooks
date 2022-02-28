package signup;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/member/controller")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public boolean containSpecialFont(String str) {
		boolean valid = false;
		for (char ch : str.toCharArray()) {
			int c = (int) ch;
			if ((c >= 33 && c <= 47) || (c >= 58 && c <= 64) || (c >= 91 && c <= 96) || (c >= 123 && c <= 126)) {
				valid = true;
			}
		}
		return valid;
	}

	public boolean containUpperEng(String str) {
		boolean valid = false;
		for (char ch : str.toCharArray()) {
			int c = (int) ch;
			if (c >= 65 && c <= 90) {
				valid = true;
			}
		}
		return valid;
	}

	public boolean containLowerEng(String str) {
		boolean valid = false;
		for (char ch : str.toCharArray()) {
			int c = (int) ch;
			if (c >= 97 && c <= 122) {
				valid = true;
			}
		}
		return valid;
	}

	public boolean containInt(String str) {
		boolean valid = false;
		for (char ch : str.toCharArray()) {
			int c = (int) ch;
			if (c >= 48 && c <= 57) {
				valid = true;
			}
		}
		return valid;
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// POST동작 - 회원가입
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
		String required1 = request.getParameter("required1");
		String required2 = request.getParameter("required2");
		
		MemberDao dao = new MemberDao();
		// member테이블에 저장하는게 나을지 아님 처음 했던데로 Agree테이블에 따로 저장하는게 나을지??
		boolean EmailCheck = dao.getEmailCheckBoolean(Email);
		boolean Idcheck = dao.getIdCheckBoolean(Id);
		// 아이디와 이메일 중복 확인
		if (Idcheck != false || EmailCheck != false) {
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			return;
		}
		// 필수동의 여부 확인
		if (required1 == null || required2 == null || required2.isEmpty() || required1.isEmpty()) {
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			return;
		}
		// 파라미터 길이 제한 확인
//		if((Id.length()<5 || Id.length()>20) || (Pw.length()<8 || Pw.length()>18) || (Email.length()>30) || Name.length()>17) {
//			statusCode = 401; return statusCode;
//		}		
		// 비밀번호와 비밀번호 확인의 값은 같아야함.
		if (!Pw.equals(Pw2)) {
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			return;
		}
//		if(!Email.contains("@naver.com") || Email.contains("@google.com")) { statusCode = 401; return statusCode;}

		// 회원가입 규칙
		// 1. 아이디 : 5~20자의 영문,숫자로 이루어짐
		int ValSort = 0;
		boolean IdValidator = Pattern.matches("^\\w{5,20}$", Id);
		System.out.println(IdValidator);
		if (IdValidator == false) {
			System.out.println("Id 검증 실패 : " + Id);
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			return;
		}

		// 2. 비밀번호 : 8자 이상, 영문/숫자/특수문자 중 2가지 이상 입력
		if (containInt(Pw)) {
			ValSort++;System.out.println("숫자 : "+ValSort);
		}
			
		if (containSpecialFont(Pw)) {
			ValSort++;System.out.println("특수문자 : "+ValSort);
		}
		
		if (containUpperEng(Pw) || containLowerEng(Pw)) {
			ValSort++;System.out.println("대문자 : "+ValSort);
		}

		if (ValSort < 2) {
			System.out.println(ValSort);
			System.out.println("Pw 검증 실패 " + Pw);
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			return;
		}
//		boolean PwValidator = Pattern.matches("^(\\w|\\W){8,}$", Pw);
//		System.out.println("8글자 이상 인지 확인="+PwValidator);
//		if(Pattern.matches("[A-Za-z]g" ,Pw)){ValSort=ValSort+1;}
//		Matcher matcher = Pattern.compile("[A-Za-z]+").matcher(Pw);
//		System.out.println("Matcher결과 ="+matcher.find());
//		System.out.println(Pattern.matches("[A-Za-z]+" ,Pw));
//		System.out.println(ValSort);
//		if(Pattern.matches("[0-9]+" ,Pw)) ValSort++;
//		System.out.println(ValSort);
//		if(Pattern.matches("[~!@#$%^&*]+" ,Pw)) ValSort++;
//		System.out.println(ValSort);

		// 3. 이메일 주소 : @가 있어야함. @다음에 .이 있어야함
		boolean Emailvalidator = Pattern.matches("\\w+@\\w+\\.\\w+(\\.\\w+)?", Email);
		if (Emailvalidator == false) {
			System.out.println("이메일 검증 실패 : " + Email);
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			return;
		}

		// 4. 이름은 한글로입력해야한다.
		boolean NameValidator = Pattern.matches("^[가-힣]*$", Name);
		if(NameValidator == false) {
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			System.out.println("이름 검증 실패 : "+Name);
			return;
		}
		// 5. 출생년도는 현재 14세 이상의 사람만 회원가입 할 수 있다.
		int year = LocalDateTime.now().getYear();
		boolean agevalidator = year - Integer.parseInt(Birth) > 14;
		if(agevalidator == false) {
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			System.out.println("나이 검증 실패 : "+Name);
			return;
		}
		MemberDto member = new MemberDto();
		member.setId(Id);
		member.setPw(Pw);
		member.setName(Name);
		member.setBirth(Birth);
		member.setSex(Sex.charAt(0));
		member.setEmail(Email);

		boolean success = dao.insertMemebr(member);
		if (Agree1.equals("agree")) {
			member.setAgree1(Agree1);
			dao.insertAgree1(member);
		}
		if (Agree2.equals("agree")) {
			member.setAgree2(Agree2);
			dao.insertAgree2(member);
		}

		boolean insertSuccess = dao.insertMemebr(member);
		if(insertSuccess == true) {
			response.setStatus(statusCode);
		}
		
		// 회원가입기능 실행시 결과(상태코드)를 전달
		// 성공적으로 회원가입시 200코드 전달됨. 
		
		if(statusCode == HttpServletResponse.SC_OK) {
			// 상태코드가 200이면 다음 페이지로 이동
			response.sendRedirect("/ridibooks/login.html"); 
		}else {
			response.sendRedirect("/ridibooks/signupcontent.html");
		}
	}

}
