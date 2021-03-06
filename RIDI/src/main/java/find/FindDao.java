package find;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class FindDao {
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

	public String findIdByEmail(String email) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String Id = null;
		
		try {
			conn = getConnection();
			String sql = "SELECT * FROM member WHERE Email=?;";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, email);
			 	
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) Id=rs.getString("Id");
			// 행이 존재할때 그 행의 "Id" 값을 Id변수에 저장한다.
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
		
		
		return Id;
	}
	
	public String resetPw(String id, String email, String resetedPw) {
		String foundPw=null;		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = getConnection();
			String sql = "UPDATE member SET Pw=? WHERE id=? AND email=?";
			pstmt = conn.prepareStatement(sql);
			
			
			pstmt.setString(1, resetedPw);
			pstmt.setString(2, id);
			pstmt.setString(3, email);
			pstmt.setInt(2, 2);
			
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
		return foundPw;
	}

	public int findPw(String id, String email) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int Id_Num = 0;
		
		try {
			conn = getConnection();
			String sql = "SELECT * FROM member WHERE Email=? AND Id=?;";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, email);
			pstmt.setString(2, id);
			 	
			ResultSet rs = pstmt.executeQuery();
			
			 if(rs.next()) {
				 // 해당하는 회원이 있다면 고유번호를 저장해서 반환한다.
				 Id_Num = Integer.parseInt(rs.getString("Id_Num"));
			 }
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
		
		
		return Id_Num;
	}

	public boolean reset(String pw, PwDto pwDto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int Id_Num = pwDto.getId_Num();
		boolean success=false;
		try {
			conn = getConnection();
			String sql = "UPDATE member SET Pw=? WHERE Id_Num=?";
			pstmt = conn.prepareStatement(sql);
			
			
			pstmt.setString(1, pw);
			pstmt.setInt(2, Id_Num);
			
			int result = pstmt.executeUpdate();
			if(result>0) {success=true;}
		
			
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
}
