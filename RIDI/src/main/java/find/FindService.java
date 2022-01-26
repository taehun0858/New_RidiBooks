package find;


public class FindService {

	public String findIdByEmail(String email) {
		FindDao dao = new FindDao();
		String foundId = dao.findIdByEmail(email);
		return foundId;
	}
	
	public String resetPw(String id, String email) {
		FindDao dao = new FindDao();
		String foundPw = dao.resetPw(Pw,resetedPw);
		return foundPw;
	}

	public String findPw(String id, String email) {
		FindDao dao = new FindDao();
		String foundPw = dao.findPw(id,email);
		
		return foundPw;
	}
	
}
