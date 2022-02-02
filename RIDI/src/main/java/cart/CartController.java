package cart;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

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
		// 로그인한 상태인지 아닌지 확인
		HttpSession session = request.getSession();		
		if(session.getAttribute("isLogin")!=null || Integer.parseInt((String) session.getAttribute("isLogin"))!=0) {
			// 세션의 isLogin속성 값을 가져옴 그 속성값은 결국 로그인한 아이디의 아이디 고유번호일것임, isLogin이 비었거나 0이라면
			// 로그인이 안되있는상태라는것임. 세션의 isLogin속성이 있을때 200코드를 반환해서 에이잭스로 받아서 카트페이지로 이동
			response.setStatus(200);			
		}else{
			response.setStatus(400);
			// 로그인이 안되어있는 상태라는 거기 때문에 400 코드 반환, 에이잭스에서는 그걸 받아서 로그인 화면으로 이동할것임
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 카트 페이지로 이동했을때 로그인한 아이디가 카트에 들옥해놓은 책들 목록을 전달해줘야함.
		request.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession();
		if(session.getAttribute("isLogin")!=null || Integer.parseInt((String) session.getAttribute("isLogin"))!=0) {
			// 로그인을 하고 카트페이지에 왔을때
			String loginIdNum = (String) session.getAttribute("isLogin");
			//loginIdNum은 세션의 isLogin에 저장되어있는 로그인한 회원의 고유번호를 가져옴
			CartService service = new CartService(loginIdNum);
			//가져온 고유번호를 이용해서 서비스를 만듦.
			List<Book> books = service.getCartBooks();
			PrintWriter writer = response.getWriter();
			writer.print(books);
		}
		
		
		
	}

}
