package book;

import java.io.IOException;
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
// 책 표지나 작가이름 등 이벤트마다 필요한 책들을 JSON으로 보내주는 컨트롤러
public class BookController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		String sql = request.getParameter("sql");
		
		BookDao dao = new BookDao();
		List<BookDto> books = dao.getbooks(sql);
		
	}
}
