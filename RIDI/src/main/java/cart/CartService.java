package cart;

import java.util.List;

public class CartService {
	CartDao dao = new CartDao();
	int loginIdNum;
	
	public CartService(Integer loginIdNum) {
		this.loginIdNum=loginIdNum;
	}

	public List<Book> getCartBooks() {
		List<Book> books = dao.getCartBooks(loginIdNum);
		return books;
	}

	public boolean cartIn(int bookNum) {
		// false를 반환한다면 책을 카트에 넣는 과정에서 문제가 있거나 이미 카트에 똑같은 책이 있다는 것임.
		// 정상적으로 한다면 사실 false를 받을 수 없음
		Book book = dao.findBook(bookNum);
		boolean dupCheck = dao.dupCheckInCart(loginIdNum,bookNum);
		if(dupCheck==false) {
			return false;
		}
		boolean success = dao.putBookInCart(loginIdNum,book);
		return success;
	}

	public boolean cartout(int bookNum) {
		
		boolean success = dao.DeleteBookInCart(loginIdNum,bookNum);
		return success;
	}
	
	

}
