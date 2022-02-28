package buy;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/buy")
public class BuyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int totalPrice = Integer.parseInt(request.getParameter("totalPrice"));
		String payBy = request.getParameter("payBy");
		String agree = request.getParameter("agree");
		int bookNum = Integer.parseInt(request.getParameter("bookNum"));
		// 살 책이 여러개 일때는 bookNum에 값이 여러개 들어올 것임 구분하는것은 ,로 구분될듯 => 예상이니깐 화면 구성하고 테스트하면서 확인해보기
		// 예상과 다르다면 여러개의 책을사게하는 컨트롤러 또 만들어야 할듯함.
		int IdNum = Integer.parseInt((String)request.getSession().getAttribute("isLogin"));
		BuyDao dao = new BuyDao();
		if(!dao.checkBook(bookNum) || !dao.checkId(IdNum)) {
			response.setStatus(405);
			// 등록되지 않은 책이나 아이디 일때 상태코드에 405전달
		}
		if(payBy.equals("ridiCash")) {			
			if(totalPrice <= dao.getRidiCash(IdNum)) {
				boolean success = dao.buyBook(bookNum,IdNum);
				if(success) {
					response.setStatus(200);
					dao.deduct(IdNum,totalPrice);
				}
				// 책을 사서 산 사람의 서재에 넣기가 성공 했다면 200상태코드에 저장
				else response.setStatus(402); 
				// 서재에 넣기가 실패했다면 402저장
			}
		}else {
			response.setStatus(404);
			// 리디캐시가 아닌 다른 구매수단을 눌렀을 때 404 코드를 저장
		}
		
	}

}
