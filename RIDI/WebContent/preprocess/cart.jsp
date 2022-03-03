<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <!-- 본문 (카트) -->
    <div class="bookcontent">
        <section id="cartpage">
            <h2>카트</h2>
            <div class="cart-wrapper">
                <ul class="carttab">
                    <li class="buy">
                        <a href="#">
                            구매 가능
                            <span>1</span>
                        </a>
                    </li>
                    <li class="rent">
                        <a href="#">
                            대여 가능
                        </a>
                    </li>
                </ul>
                <form action="post">
                    <article class="summary">
                        <div class="summarybox">
                            <p class="count">
                                <span><i class="fa-solid fa-circle-check"></i></span>
                                1권을 선택하셨습니다.
                            </p>
                            <ul class="priceinfo">
                                <li class="total">
                                    <span class="totalwrapper">
                                        <span class="text">총 상품 금액</span>
                                        <span class="price">9,660원</span>
                                    </span>
                                </li>
                                <li class="discount">
                                    <span class="totalwrapper">
                                        <span class="text">할인 금액</span>
                                        <span class="price" >0원</span>
                                    </span>
                                </li>
                            </ul>
                            <p class="totalprice">
                                <span class="text">합계</span>
                                <span class="price">9,660원</span>
                            </p>
                        </div>
                        <div class="buybutton">
                            <button type="submit">
                                선택 구매하기
                            </button>
                        </div>
                    </article>
                    
                    <article class="cartlist">
                        <div class="cartlistbox">
                            <div class="module-list">
                                <div class="totalcheckbox">
                                    <input type="checkbox" id="bookcheck">
                                    <label for="bookcheck">전체 선택</label>
                                </div>
                                <div class="button-wrapper">
                                    <ul>
                                        <li class="wishlist">
                                            <button type="button">선택 위시리스트로 이동</button>
                                        </li>
                                        <li class="delete">
                                            <button type="button">선택 삭제</button>
                                        </li>
                                    </ul>
                                </div>
                            </div>
                            <div class="booklist">
                                <div class="list-wrapper">
                                    <div class="thumbnail">
                                        <div class="thumbnail-checkbox">
                                            <input type="checkbox" id="listcheck">
                                            <label for="listcheck"></label>
                                        </div>
                                        <img src="images/popular.jpg" alt="달러구트 꿈 백화점 2">
                                    </div>
                                    <div class="bookcontent">
                                        <div class="content-wrapper">
                                            <div class="book-metadata">
                                                <h3>달러구트 꿈 백화점2</h3>
                                                <p>이미예</p>
                                            </div>
                                            <div class="price-wrapper">
                                                <span> - </span>
                                                <strong>9,660원</strong>
                                            </div>
                                        </div>
                                        <div class="wish-button">
                                            <ul>
                                                <li style="margin-right: 4px;">
                                                    <button type="button">위시리스트로 이동</button>
                                                </li>
                                                <li>
                                                    <button type="button">삭제</button>
                                                </li>
                                            </ul>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="module-list" style="border-top: 1px solid #d1d5d9;">
                                <div class="totalcheckbox">
                                    <input type="checkbox" id="bookcheck">
                                    <label for="bookcheck">전체 선택</label>
                                </div>
                                <div class="button-wrapper">
                                    <ul>
                                        <li class="wishlist">
                                            <button type="button">선택 위시리스트로 이동</button>
                                        </li>
                                        <li class="delete">
                                            <button type="button">선택 삭제</button>
                                        </li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </article>
                </form>
            </div>
        </section>
    </div>