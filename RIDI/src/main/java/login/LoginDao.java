package login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class LoginDao {

	// DB접속
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
	
	
	public int getLoginMemebr(String id, String pw) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int successId = 0;
			
		try {
			conn = getConnection();
			String sql = "SELECT * FROM member WHERE id=? AND pw=?;";
			pstmt = conn.prepareStatement(sql);
				
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
				 	
			ResultSet rs = pstmt.executeQuery();
				
			if(rs.next()) successId=rs.getInt("Id_Num");
			rs.close();
							
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
			
		return successId;
	}


	public void loginDateUpdate(String id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
			
		try {
			conn = getConnection();
			String sql = "UPDATE member SET m_redate=? WHERE id=?;";
			pstmt = conn.prepareStatement(sql);
			LocalDateTime m_redate = LocalDateTime.now();
			DateTimeFormatter dft = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"); 
			pstmt.setString(1, dft.format(m_redate));
			pstmt.setString(2, id);
			int result = pstmt.executeUpdate();
						
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
		
		
	}


	public int getLoginIdNum(String id) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		int IdNum = 0;
		
		try {
			conn = getConnection();
			String sql = "SELECT Id_Num FROM member WHERE id=?;";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, id);
			 	
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) IdNum = rs.getInt("Id_Num");
			rs.close();
							
						
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
		
		return IdNum;
	}

}
