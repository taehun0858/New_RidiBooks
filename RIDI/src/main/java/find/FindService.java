package find;


public class FindService {

	public String findIdByEmail(String email) {
		FindDao dao = new FindDao();
		String foundId = dao.findIdByEmail(email);
		return foundId;
	}
<<<<<<< HEAD
	
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
	
=======

	public String findPw(PwDto member) {
		FindDao dao = new FindDao();
		String id = member.getId();
		String email = member.getEmail();
		String Pw = dao.findPw(id, email);
		return Pw;
	}

	public boolean resetPw(PwDto member, String Pw) {
		FindDao dao = new FindDao();
		boolean success = dao.reset(Pw, member);
		
		return success;
	}

>>>>>>> feature/newbackend
}
