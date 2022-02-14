package cart;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CartInOut
 */
@WebServlet("/cartinout")
public class CartInOut extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 페이지에서 보내는 동작의 종류가 in인지 out인지 확인해서 맞는 동작을 한다.
		String requestType = request.getParameter("active");
		int bookNum = Integer.parseInt((String)request.getParameter("bookNum"));
		int idNum = Integer.parseInt((String) request.getSession().getAttribute("isLogin"));
		CartService service = new CartService(idNum);
		boolean success = false;
		if(requestType.equals("in")) { 
			// 동작이 in 이면 카트에 넣기
			success = service.cartIn(bookNum);
			// 카트에서 빼려면 카트에 없는 상태인지 알아야함
			// success에 동작의 성공 여부를 저장함
		}else if(requestType.equals("out")) {
			// 동작이 out 이면 카트에서 빼기
			// 카트에서 빼려면 캍트에 등록된 상태인지 알아야함
			// success에 동작의 성공 여부를 저장함
			success=service.cartout(bookNum);
		}
		if(success==true) {response.setStatus(200);}
		else {response.setStatus(400);}
		
	}

}
