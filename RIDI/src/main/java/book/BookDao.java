package book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import search.SearchDto;

public class BookDao {
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
	public List<BookDto> getbooks(String sql) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		List<BookDto> results = new ArrayList<>();

		try {
			conn = getConnection();
//			sql = "SELECT * FROM book WHERE b_name LIKE ? OR b_publisher LIKE ? OR b_author LIKE ?;";
			pstmt = conn.prepareStatement(sql);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				// 제목, 
				// 해당 행이 없을 때 까지 반복.
				String title = rs.getString("b_name");
				String imageurl = rs.getString("b_imageUrl");
				String author = rs.getString("b_author");
				String publisher = rs.getString("b_publisher");
				int booknum = rs.getInt("b_num");
				BookDto result = new BookDto();
				result.setTitle(title);
				result.setBookNum(booknum);
				result.setImageUrl(imageurl);
				result.setAuthor(author);
				result.setPublisher(publisher);
				results.add(result);

			}
			rs.close();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (pstmt != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		return results;
	}

}
