package alarm;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;

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

	public Collection<AlarmDto> getAlarmProducts(int loginIdNum) {
		// 아이디 고유값으로 알람 데이터베이스에서 고유번호에 해당하는 모든 정보들을 가져옴
		// 그 정보들중에서 사진url과 상품 이름, 상품 가격 을productDto에 저장
		// 조회된 모든 행들의 정보들을(url,이름,가격) productDto타입의 변수에 저장해서 
		// productDto타입의 Collection에 넣기
		Connection conn = null;
		PreparedStatement pstmt = null;
		boolean success = false;	
		Collection<AlarmDto> products = null;
		
		try {
			conn = getConnection();
			String sql = "SELECT * FROM alarms WHERE m_Num = ?;";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, loginIdNum);
		
			
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				// 다음 행이 없을 때 까지 이름과 가격 url을 가져와서 AlaramDto타입의 변수에 저장하고 Collection(products)에 넣기 
				
			}
			
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
		
		return products;
	}
	
}
