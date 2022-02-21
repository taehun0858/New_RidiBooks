package buy;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class BuyDao {
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

	public boolean checkBook(int bookNum) {
		Connection conn = null;
		PreparedStatement pstmt = null;		
		boolean success = false;
		try {
			conn = getConnection();
			String sql = "SELECT * FROM book WHERE b_num=?;";
			pstmt = conn.prepareStatement(sql);			
			pstmt.setInt(1, bookNum);			 	
			ResultSet rs = pstmt.executeQuery();			
			if(rs.next()) success=true;			
						
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

	public boolean checkId(int idNum) {
		Connection conn = null;
		PreparedStatement pstmt = null;		
		boolean success = false;
		try {
			conn = getConnection();
			String sql = "SELECT * FROM member WHERE Id_Num=?;";
			pstmt = conn.prepareStatement(sql);			
			pstmt.setInt(1, idNum);			 	
			ResultSet rs = pstmt.executeQuery();			
			if(rs.next()) success=true;			
						
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

	public boolean buyBook(int bookNum, int idNum) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		boolean success = false;		
		
		try {
			conn = getConnection();
			String sql = "INSERT INTO mylib(Id_Num,b_num) VALUES(?,?);";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, idNum);
			pstmt.setInt(2, bookNum);
			
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

	public int getRidiCash(int idNum) {
		Connection conn = null;
		PreparedStatement pstmt = null;		
		int ridicash=0;
		try {
			conn = getConnection();
			String sql = "SELECT * FROM member WHERE Id_Num=?;";
			pstmt = conn.prepareStatement(sql);			
			pstmt.setInt(1, idNum);			 	
			ResultSet rs = pstmt.executeQuery();			
			if(rs.next()) {			
				ridicash = rs.getInt("cash");
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
		return ridicash;
	}

	public boolean deduct(int idNum, int totalPrice) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		boolean success = false;		
		
		try {
			conn = getConnection();
			String sql = "UPDATE member SET cash = cash-? WHERE Id_Num=?;";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, totalPrice);
			pstmt.setInt(2, idNum);
			
			int result = pstmt.executeUpdate();
			
			success = result == 1;
			System.out.println("success="+success);
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
