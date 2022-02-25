package find;

import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class FindService {
	private FindDao dao = new FindDao();
	public String findIdByEmail(String email) {
		// 이메일로 아이디를 찾는다.
		dao = new FindDao();
		String foundId = dao.findIdByEmail(email);
		return foundId;
	}

	public int findIdNum(PwDto member) {
		// 아이디와 이메일로 아이디 고유 번호를 찾는다.
		dao = new FindDao();
		String id = member.getId();
		String email = member.getEmail();
		int Id_Num = dao.findPw(id, email);
		return Id_Num;
	}

	public boolean resetPw(PwDto member, String Pw) {
		// 비밀번호를 재설정한다.
		dao = new FindDao();
		boolean success = dao.reset(Pw, member);
		
		return success;
	}

	public void sendEmail(PwDto member) {
		// 입력한 정보를 토대로 메일을 보낸다.
		  Properties p = System.getProperties();
	        p.put("mail.smtp.starttls.enable", "true");     // gmail은 true 고정
	        p.put("mail.smtp.host", "smtp.naver.com");      // smtp 서버 주소
	        p.put("mail.smtp.auth","true");                 // gmail은 true 고정
	        p.put("mail.smtp.port", "587");                 // 네이버 포트
	        p.put("mail.smtp.port", "587");                 // 네이버 포트
	           
	        Authenticator auth = new MyAuthentication();
	        //session 생성 및  MimeMessage생성
	        Session session = Session.getDefaultInstance(p, auth);
	        MimeMessage msg = new MimeMessage(session);
	         
	        try{
	            //편지보낸시간
	            msg.setSentDate(new Date());
	            InternetAddress from = new InternetAddress() ;
	            from = new InternetAddress("ekdh0858@naver.com"); //발신자 아이디
	            // 이메일 발신자
	            msg.setFrom(from);
	            // 이메일 수신자
	            InternetAddress to = new InternetAddress(member.getEmail());
	            msg.setRecipient(Message.RecipientType.TO, to);
	            // 이메일 제목
	            msg.setSubject("비밀번호 재설정 테스트", "UTF-8");
	            // 이메일 내용
	            msg.setText(" 리디북스 프로젝트 의 비밀번호 변경 링크가 있는 메세지 입니다. </br>"
	            		+ "<a href=\"http://localhost:80/ridibooks/findIdTest.jsp?Id_Num="+member.getId_Num()+"\">비밀번호 바꾸기</a>", "UTF-8");
	            // 이메일 헤더
	            msg.setHeader("content-Type", "text/html");
	            //메일보내기
	            Transport.send(msg, msg.getAllRecipients());
	             
	        }catch (AddressException addr_e) {
	            addr_e.printStackTrace();
	        }catch (MessagingException msg_e) {
	            msg_e.printStackTrace();
	        }catch (Exception msg_e) {
	            msg_e.printStackTrace();
	        }
	    }
	}
	 
	class MyAuthentication extends Authenticator {
	      
	    PasswordAuthentication pa;
	    public MyAuthentication(){
	         
	        String id = "ekdh0858";  //네이버 이메일 아이디
	        String pw = "go92212858*";        //네이버 비밀번호
	 
	        // ID와 비밀번호를 입력한다.
	        pa = new PasswordAuthentication(id, pw);
	    }
	 
	    // 시스템에서 사용하는 인증정보
	    public PasswordAuthentication getPasswordAuthentication() {
	        return pa;
	    }
		
	}

