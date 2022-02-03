package cart;

import java.util.List;

public class CartService {
	int loginIdNum;
	
	public CartService(Integer loginIdNum) {
		this.loginIdNum=loginIdNum;
	}

	public List<Book> getCartBooks() {
		CartDao dao = new CartDao();
		List<Book> books = dao.getCartBooks(loginIdNum);
		return books;
	}

	public boolean cartIn(String bookNum) {
		CartDao dao = new CartDao();
		return false;
	}
	
	

}
