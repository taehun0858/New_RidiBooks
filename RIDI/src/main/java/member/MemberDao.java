package member;

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

	// Id_Num을 반환해주는 메서드 
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
		
		
		
		int result ;
		return foundPw;
	}
}
