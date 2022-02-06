package search;

import java.util.List;

public class SearchService {
	SearchDao dao =new SearchDao();
	public List<SearchDto> searchResults(String word) {
		// word에 대한 검증
		List<SearchDto> results = dao.searchResults(word);
		return results;
	}

}
