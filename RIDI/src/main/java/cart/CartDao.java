package cart;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class CartDao {

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

	public List<Book> getCartBooks(String loginIdNum) {
		// 로그인 고유번호에 해당하는 카트에 담긴 책들을 보내줌
		Connection conn = null;
		PreparedStatement pstmt = null;
		List<Book> books = new ArrayList<Book>();
		try {
			conn = getConnection();
			String sql = "SELECT * FROM cart WHERE m_num=?;";
			// 조인을 해야하는데 아직 조인을 잘 몰라서 못씀
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, loginIdNum);
			 	
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				// 행이 없을때 까지 행에 있는 책 제목과 가격 출판사를 Book타입 변수에 저장
				String bookName = rs.getString("b_name");
				int bookprice = rs.getInt("b_price");
				String bookPublisher = rs.getString("b_publisher");
				Book book = new Book();
				book.setPrice(bookprice);
				book.setPublisher(bookPublisher);
				book.setTitle(bookName);
				books.add(book);
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
		
		
		return books;
		
	}
	
}
