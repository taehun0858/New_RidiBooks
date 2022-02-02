package cart;

import java.util.List;

public class CartService {
	String loginIdNum;
	
	public CartService(String loginIdNum) {
		this.loginIdNum=loginIdNum;
	}

	public List<Book> getCartBooks() {
		CartDao dao = new CartDao();
		List<Book> books = dao.getCartBooks(loginIdNum);
		return books;
	}
	
	

}
