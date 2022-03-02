package wishList;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/wishinout")
public class WishlistController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 페이지에서 원하는 행동이 무엇인지 확인한 후에 그에 맞는 행동을 함(in-> 위시리스트에 넣기, out->위시리스트에서 빼기, show->내 위시리스트 보여주기)
		String active = request.getParameter("active");
		int bookNum = Integer.parseInt(request.getParameter("booknum"));
		int IdNum = Integer.parseInt((String)request.getSession().getAttribute("isLogin"));
		
		if(IdNum==0) { 		
			response.setStatus(404);
			//로그인이 되어있는 상태가 아니면 404코드 반환
		}
		
		WishListService service = new WishListService();
		List<WishListDto> wishList = new ArrayList<>();
		boolean success = false;
		if(active.equals("in")) {
			success = service.inWishList(bookNum,IdNum);
			if(success==false) {
				response.setStatus(401);
				// 위시리스트 집어넣을때 문제가 발생하면 401에러
			}
		}else if(active.equals("out")) {
			success = service.outWishList(bookNum,IdNum);
			if(success==false) {
				response.setStatus(402);
				// 위시리스트에서 뺄 때 문제가 발생하면 402에러
			}

		}else if(active.equals("show")) {
			wishList = service.showWishList(IdNum);
			if(wishList==null || wishList.isEmpty()) {
				request.setAttribute("wishList", wishList);
				RequestDispatcher rd = request.getRequestDispatcher("위시리스트 페이지");
				rd.forward(request, response);
			}
		}
		if(success==true) response.setStatus(200);
		// 동작을 완료 했다면 200코드(위시리스트 보여주기(show)는 여기까지 안옴.) 
		
		
		 
	}


}
