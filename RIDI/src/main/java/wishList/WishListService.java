package wishList;

import java.util.List;

public class WishListService {
		WishListDao dao = new WishListDao();
	public boolean inWishList(int bookNum, int idNum) {
		// 위시리스트로 책을 넣어라는 명령을 내리면 위시리스트 안에 같은 책이 있는지 확인하고,
		// 위시리스트 안에 같은 책이 없다면 위시리스트로 책을 넣는다.
		// 정상적인 접근이라면 당연히 위시리트스 안에 같은 책이 없음.
		boolean success = false;
		boolean dupCheck = dao.dupCheck(bookNum,idNum);
		if(dupCheck==true) {
			success = dao.putBookToWishList(bookNum,idNum);
		}
		return success;
	}
	public boolean outWishList(int bookNum, int idNum) {
		boolean success = dao.deleteBookFromWishList(bookNum,idNum);
		return success;
	}
	public List<WishListDto> showWishList(int idNum) {
		List<WishListDto> wishList = dao.showWishList(idNum);
		return wishList;
	}

}
