package wishList;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/wishinout")
public class WishlistController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 페이지에서 원하는 행동이 in인지 out인지 확인한 후에 그에 맞는 행동을 함
		String active = request.getParameter("active");
		int bookNum = Integer.parseInt(request.getParameter("booknum"));
		int IdNum = Integer.parseInt((String)request.getSession().getAttribute("isLogin"));
		WishListService service = new WishListService();
		boolean success = false;
		if(active.equals("in")) {
			success = service.inWishList(bookNum,IdNum);
		}else if(active.equals("out")) {
			success = service.outWishList(bookNum,IdNum);
		}
		if(success==true) response.setStatus(200);
		else response.setStatus(400);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
	}

}
