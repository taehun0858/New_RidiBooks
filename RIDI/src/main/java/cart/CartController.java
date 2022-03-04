package cart;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/mycart")
public class CartController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 카트 페이지로 이동했을때 로그인한 아이디가 카트에 등록해놓은 책들 목록을 전달해줘야함.
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("UTF-8");
		HttpSession session = request.getSession();
		if(session.getAttribute("isLogin")!=null) { // || Integer.parseInt((String) session.getAttribute("isLogin"))!=0) {
			// 로그인을 하고 카트페이지에 왔을때
			Integer loginIdNum = (Integer) session.getAttribute("isLogin");
			//loginIdNum은 세션의 isLogin에 저장되어있는 로그인한 회원의 고유번호를 가져옴
			CartService service = new CartService(loginIdNum);
			//가져온 고유번호를 이용해서 서비스를 만듦.
			List<Book> books = service.getCartBooks();
			PrintWriter out = response.getWriter();
//			writer.print(books); => 에이잭스의 json으로 객체 전달할때 사용할것.
			String[] data = new String[books.size()];
			for (int i = 0; i <= books.size() - 1; i++) {
				data[i] = " {\"title\": \"" + books.get(i).getTitle() + "\", \"publisher\":\""+ books.get(i).getPublisher()
						+"\", \"bookNum\":\""+ books.get(i).getBookNum()+"\", \"imageurl\":\""+ books.get(i).getAuthor()
						+"\", \"imageurl\":\""+ books.get(i).getImageUrl()+  "\"}";
			}
//			String result = Arrays.toString(data);
//			System.out.println(result);
//			out.print(result);
//			out.close();
			
			RequestDispatcher rd = request.getRequestDispatcher("/Cart.jsp");
			rd.forward(request, response);
			response.setStatus(HttpServletResponse.SC_OK);
		}else {
			response.sendRedirect("login.html");
			response.setStatus(HttpServletResponse.SC_BAD_GATEWAY);
			
		}
		
		
		
	}

}
