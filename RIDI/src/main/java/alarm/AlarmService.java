package alarm;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


public class AlarmService {

	public boolean checkLoginStatus(HttpServletRequest request) {
		HttpSession session = request.getSession();
		boolean loginBoolean = false;
		if(session.getAttribute("isLogin")==null) {
			loginBoolean = false;
		}else {
			loginBoolean = true;
		}
		
		
		return loginBoolean;
	}

	public Collection<AlarmDto> getAlarms(int loginIdNum) {
		// 로그인 아이디의 고유 번호를 받아왔음. -> 다오로 그 고유번호에 해당하는 아이디의 알람들을 보여줄 수 있어야함
		AlarmDao dao = new AlarmDao();
		Collection<AlarmDto> alarms = dao.getAlarmProducts(loginIdNum);
		// 다오로 데이터 베이스에 저장된 로그한 아이디의 고유번호의 상품 정보들을 가져옴.
		// 그 정보들을 반환해야함. 반환하는 것들은 AlarmDto 타입의 Collection
		return alarms;
	}


}
