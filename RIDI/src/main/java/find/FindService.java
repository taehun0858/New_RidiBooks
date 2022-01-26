package find;


public class FindService {

	public String findIdByEmail(String email) {
		FindDao dao = new FindDao();
		String foundId = dao.findIdByEmail(email);
		return foundId;
	}

	public PwDto findPw(String id, String email) {
		FindDao dao = new FindDao();
		PwDto foundPw = (PwDto) dao.findPw(id,email);
		
		return foundPw;
	}

	public boolean resetPw(String pw, PwDto pwDto) {
		FindDao dao = new FindDao();
		boolean success = dao.reset(pw,pwDto);
		return success;
	}
}
