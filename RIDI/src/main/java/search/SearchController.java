package search;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/search")
public class SearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    // 에이잭스로 사용할 것임.
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String active = request.getParameter("active");
		String word = request.getParameter("searchWord");
		SearchDao dao = new SearchDao();
		List<SearchDto> results= new ArrayList<>();
		
		if(active.equals("show")) {
			results= dao.searchResults(word);
			request.setAttribute("searchResults", results);
			
		}else if(active.equals("autosearch")) {
			results = dao.autoSearchResults(word);	
			request.setAttribute("autoSearchResults", results);
			// 오토서치에서 다른점은 책의 이름과 출판사, 저자만 보여주는 results 를 전달해줘야함
		}
		
		if(results==null) response.setStatus(203);
		else if(results!=null) response.setStatus(200);
		
				
	}
}
