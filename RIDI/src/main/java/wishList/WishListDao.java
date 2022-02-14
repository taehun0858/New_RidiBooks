package wishList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import cart.Book;

public class WishListDao {

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

	public boolean dupCheck(int bookNum, int idNum) {

		// 책을 위시리스트에 넣기 전 카트에 이미 담긴 책은 아닌지 확인한다.
		// 정상적인 방법으로 책을 카트에 넣으려고 한다면 위시리스트에 이미 담겨 있을 수가 없음
		// 카트에 이미 담겨진 책이라면 false반환
		Connection conn = null;
		PreparedStatement pstmt = null;
		boolean dupcheck = true;
		try {
			conn = getConnection();
			String sql = "SELECT * FROM wishList WHERE b_num=? AND Id_Num=?;";
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, bookNum);
			pstmt.setInt(2, idNum);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {

				dupcheck = false;
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

		return dupcheck;

	}

	public boolean putBookToWishList(int bookNum, int idNum) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		boolean success = false;		
		
		try {
			conn = getConnection();
			String sql = "INSERT INTO wishList(Id_Num,b_num) VALUES(?,?);";
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

	public boolean deleteBookFromWishList(int bookNum, int idNum) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		boolean success = false;		
		
		try {
			conn = getConnection();
			String sql = "DELETE FROM wishList WHERE Id_Num=? AND b_num=?;";
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

	public List<WishListDto> showWishList(int idNum) {
		// 로그인 고유번호에 해당하는 카트에 담긴 책들을 보내줌
				Connection conn = null;
				PreparedStatement pstmt = null;
				List<WishListDto> wishList = new ArrayList<WishListDto>();
				try {
					conn = getConnection();
					String sql = "SELECT * FROM wishList INNER JOIN book ON wishList.b_num=book.b_num WHERE Id_Num=?;";
					// 조인을 해야하는데 아직 조인을 잘 몰라서 못씀
					pstmt = conn.prepareStatement(sql);
					
					pstmt.setInt(1, idNum);
					 	
					ResultSet rs = pstmt.executeQuery();
					
					while(rs.next()) {
						// 행이 없을때 까지 행에 있는 책 제목과 가격 출판사를 Book타입 변수에 저장
						String title = rs.getString("b_name");
						String author = rs.getString("b_authorname");
						String publisher = rs.getString("b_publisher");
						WishListDto wish = new WishListDto();
						
						wish.setTitle(title);
						wish.setPublisher(publisher);
						wish.setAuthor(author);
						
						wishList.add(wish);
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
				
				
				return wishList;
				
	}

}
