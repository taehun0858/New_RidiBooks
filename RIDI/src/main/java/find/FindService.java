package find;


public class FindService {

	public String findIdByEmail(String email) {
		FindDao dao = new FindDao();
		String foundId = dao.findIdByEmail(email);
		return foundId;
	}

	
	

	public String resetPw(String id, String email, String resetedPw) {
		FindDao dao = new FindDao();
		String foundPw = dao.resetPw(id,email,resetedPw);
		return foundPw;
	}
}
