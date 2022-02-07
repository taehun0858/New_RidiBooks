package search;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class SearchDao {
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

	public List<SearchDto> searchResults(String word) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		List<SearchDto> results= new ArrayList<>();
			
		try {
			conn = getConnection();
			String sql = "SELECT * FROM book WHERE b_name LIKE %?% OR b_publisher LIKE %?% OR b_author LIKE %?%;";
			// b_name이나 b_publisher나 b_author에 검색 결과가 들어가는 값들을 찾는다.
			pstmt = conn.prepareStatement(sql);
				
			pstmt.setString(1, word);
			pstmt.setString(2, word);
			pstmt.setString(3, word);
				 	
			ResultSet rs = pstmt.executeQuery();
				
			if(rs.next()) {
				// 제목, 이미지,저자, 소개글, 가격을 book데이터 테이블에서 가져와 searchDto에 전달하고 List에 searchDto를 저장
				// 해당 행이 없을 때 까지 반복.
				String title = rs.getString("b_name");
				String imageurl = rs.getString("b_imageUrl");
				String author = rs.getString("b_author");
				String introduce = rs.getString("b_introduce");
				int price = rs.getInt("b_price");
				SearchDto result = new SearchDto();
				result.setTitle(title);
				result.setImageUrl(imageurl);
				result.setPrice(price);
				result.setIntroduce(introduce);
				result.setAuthor(author);
				results.add(result);
				
			}
			rs.close();
							
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(conn!= null) {try {pstmt.close();} 
				catch (SQLException e) {e.printStackTrace();}
			}
				if(pstmt!= null) {try {conn.close();} 
				catch (SQLException e) {e.printStackTrace();}
			}
		}
			
		return results;
	}

}
