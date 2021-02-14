package model;

import java.util.ArrayList;

public class Cart {//장바구니 객체
	private String id;//로그인한 계정
	private ArrayList<Integer> codeList = 
			new ArrayList<Integer>();//상품번호(여러개)
	private ArrayList<Integer> numList = 
			new ArrayList<Integer>();//상품갯수(여러개)
	public Cart(String id) {
		this.id = id;
	}//생성자
	public void addCart(Integer code, Integer num) {
		for(int i=0; i<codeList.size(); i++) {
			if(codeList.get(i).equals(code)) {
				numList.set(i, numList.get(i)+num);
				return;//메서드 종료
			}//장바구니에 담긴 상품의 번호와 일치하는 경우, 상품갯수만 증가
		}//codeList에 있는 상품의 갯수만큼 반복
		codeList.add(code); //codeList에 새 상품 번호 저장
		numList.add(num);//numList에 새 상품의 갯수 저장
	}//장바구니에 상품과 갯수를 담는 메서드 
}
