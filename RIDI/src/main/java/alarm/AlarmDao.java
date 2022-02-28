package alarm;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;


public class AlarmDao {

	private Connection getConnection() {
		InitialContext ic;
		try {
			ic = new InitialContext();
			DataSource ds = (DataSource) ic.lookup("java:comp/env/maria/ridibooks");
			Connection conn = ds.getConnection();
			return conn;
		} catch (NamingException e) {
			e.printStackTrace();
			System.out.println("Connecting Pool 과 관련된 예외가 발생");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Connecting 관련된 예외가 발생");
		}

		return null;
	}

	public List<AlarmDto> getAlarmMessages(int idNum) {
		// 로그인 고유번호에 해당하는 알림에 담긴 메세지들을 보여줌
		Connection conn = null;
		PreparedStatement pstmt = null;
		List<AlarmDto> messages = new ArrayList<AlarmDto>();
		try {
			conn = getConnection();
			String sql = "SELECT * FROM alarm WHERE Id_Num=?;";
			// 조인을 해야하는데 아직 조인을 잘 몰라서 못씀
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, idNum);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				// 행이 없을때 까지 행에 있는 책 제목과 가격 출판사를 Book타입 변수에 저장
				String title = rs.getString("al_title");
				String image = rs.getString("al_image");
				String tagurl = rs.getString("aTagUrl");
				AlarmDto message = new AlarmDto();

				message.setTitle(title);
				message.setImageUrl(image);
				message.setaTagUrl(tagurl);

				messages.add(message);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

		}

		return messages;
	}


	public boolean changeAlarmStatus(int idNum, int alarmNum, int status) {
		// 선택한 설정을 넣거나 빼기에 성공한다면 true반환한다.
		Connection conn = null;
		PreparedStatement pstmt = null;
		if(status==1) status=0;
		else if(status==0) status=1;
		boolean success = false;
		
		String rowname = Integer.toString(idNum+1);
		
		try {
			conn = getConnection();
			String sql = "UPDATE alarm SET ?=? WHERE Id_num=?";
			pstmt = conn.prepareStatement(sql);
			
			
			pstmt.setString(1, rowname); // 열이름이 들어갈 자리기 때문에 String형식으로 함.(열이름은 String로 해야하는듯)
			pstmt.setInt(2, status);
			pstmt.setInt(3, idNum);
			
			int result = pstmt.executeUpdate();
			
			if(result==1) success=true;
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(conn!= null) {try {conn.close();} 
				catch (SQLException e) {e.printStackTrace();}
			}
			if(pstmt!= null) {try {pstmt.close();} 
				catch (SQLException e) {e.printStackTrace();}
			}
		}
		return success;
	}

	public int getAlarmStatus(int idNum, int alarmNum) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int CTXstatus=0;
		try {
			conn = getConnection();
			String sql = "SELECT * FROM alarm WHRER Id_Num=?;";
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, idNum);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				// 아이디 번호가 데이터 베이스에 존재할때 그 아이디의 행 중에서 바꿀 알림설정을 받아옴.
				CTXstatus = rs.getInt(alarmNum+1); // 첫 열에 아이디 고유 번호가 있기 때문에 2번째 열부터 설정이 시작됨(2번째 열=1,3번째 열->2) 
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

		}

		return CTXstatus;
		// 바꿔야하는 알림설정의 지금 상태를 보내줌
	}

}
