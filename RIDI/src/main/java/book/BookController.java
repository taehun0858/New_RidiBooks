package book;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BookController
 */
@WebServlet("/book")
// 이벤트 용 컨트롤러 책 상세 정보 페이지 컨트롤러는 아님
// 책 표지나 작가이름 등 이벤트마다 필요한 책들을 JSON으로 보내주는 컨트롤러
public class BookController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		String sql = request.getParameter("sql");
		
		BookDao dao = new BookDao();
		List<BookDto> books = dao.getbooks(sql);
		
		PrintWriter out = response.getWriter();
		if(books.size()>0) {
			String[] book = new String[books.size()];
			for (int i = 0; i <= books.size() - 1; i++) {
				book[i] = " {\"title\": \"" + books.get(i).getTitle() 
						+ "\", \"publisher\":\""+ books.get(i).getPublisher() 
						+ "\", \"author\": \""+ books.get(i).getAuthor() 
						+ "\", \"imageUrl\": \""+ books.get(i).getImageUrl() 
						+ "\", \"bookNum\": \""+ books.get(i).getBookNum() 
						+ "\"}";
			}
			String result = Arrays.toString(book);
			out.print(result);
			out.close();
		}
		
	}
}
