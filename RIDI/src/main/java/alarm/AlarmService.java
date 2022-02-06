package alarm;

import java.util.List;

public class AlarmService {
	AlarmDao dao = new AlarmDao();
	
	public List<AlarmDto> showAlarms(int idNum) {
		List<AlarmDto> messages = dao.getAlarmMessages(idNum);
		
		return messages;
	}

	public boolean changeAlarm(int idNum, int alarmNum) {
		int status = dao.getAlarmStatus(idNum,alarmNum);
		boolean success = dao.changeAlarmStatus(idNum,alarmNum,status);
		
		
		return success;
	}

}
