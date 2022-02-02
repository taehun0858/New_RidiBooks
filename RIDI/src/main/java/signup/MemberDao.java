package signup;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collection;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class MemberDao {
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
	
	// 회원가입시 회원정보를 데이터테이블에 저장 
	public boolean insertMemebr(MemberDto member) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		boolean success = false;		
		
		try {
			conn = getConnection();
			String sql = "INSERT INTO member(Id,Pw,Email,Name,Birth,m_date,m_redate,Sex) VALUES(?,?,?,?,?,?,?,?);";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getPw());
			pstmt.setString(3, member.getEmail());
			pstmt.setString(4, member.getName());
			pstmt.setString(5, member.getBirth());
			LocalDateTime joinDate = LocalDateTime.now();
			LocalDateTime logindate = LocalDateTime.now();
			
			DateTimeFormatter dft = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
			
			pstmt.setString(6, dft.format(joinDate));
			pstmt.setString(7, dft.format(logindate));
			pstmt.setString(8, String.valueOf(member.getSex())); 	
			// member의 데이터 형태가 char이지만 pstmt에서는 char저장이 없는듯-> member.getSex()를 String로 형변환
			
			int result = pstmt.executeUpdate();
			
			success = result == 1;
			
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

	// 회원가입 할때 이미 가입된 아이디 인지 확인하는 메서드
	public boolean getIdCheckBoolean(String id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		boolean result = false;
		
		try {
			conn = getConnection();
			String sql = "SELECT * FROM member WHERE id=?;";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, id);
			 	
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) result=true;
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
		
		
		return result;
	}
	
	
	// 회원가입 할때 이메일에 입력된 값이 이미 사용중인지 확인하는 메서드
	public boolean getEmailCheckBoolean(String email) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		boolean result = false;
		
		try {
			conn = getConnection();
			String sql = "SELECT * FROM member WHERE Email=?;";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, email);
			 	
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) result=true;
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
		
		
		return result;
	}

<<<<<<< HEAD
=======
	
>>>>>>> feature/newbackend

	public boolean insertAgree1(MemberDto member) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		boolean success = false;	
		
		try {
			conn = getConnection();
			String sql = "INSERT INTO memberagree(Id,a_num,a_date) VALUES(?,?,?);";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, member.getId());
			pstmt.setInt(2, 1);
			LocalDateTime agreedate = LocalDateTime.now();
			
			DateTimeFormatter dft = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
			
			pstmt.setString(3, dft.format(agreedate));
			
			int result = pstmt.executeUpdate();
			
			success = result == 1;
			
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

	public boolean insertAgree2(MemberDto member) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		boolean success = false;	
		
		try {
			conn = getConnection();
			String sql = "INSERT INTO memberagree(Id,a_num,a_date) VALUES(?,?,?);";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, member.getId());
			pstmt.setInt(2, 2);
			LocalDateTime agreedate = LocalDateTime.now();
			
			DateTimeFormatter dft = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
			
			pstmt.setString(3, dft.format(agreedate));
			
			int result = pstmt.executeUpdate();
			
			success = result == 1;
			
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

<<<<<<< HEAD
=======
	

	
>>>>>>> feature/newbackend
}
