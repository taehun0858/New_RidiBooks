package search;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/search")
public class SearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String word = request.getParameter("searchWord");
		SearchService service = new SearchService();
		
		List<SearchDto> results= service.searchResults(word);
		request.setAttribute("searchResults", results);
		
		if(results==null) response.setStatus(203);
		else if(results!=null) response.setStatus(200);
	}
}
