package model;

import java.util.ArrayList;

public class Cart {//��ٱ��� ��ü
	private String id;//�α����� ����
	private ArrayList<Integer> codeList = 
			new ArrayList<Integer>();//��ǰ��ȣ(������)
	private ArrayList<Integer> numList = 
			new ArrayList<Integer>();//��ǰ����(������)
	public Cart(String id) {
		this.id = id;
	}//������
	public void addCart(Integer code, Integer num) {
		for(int i=0; i<codeList.size(); i++) {
			if(codeList.get(i).equals(code)) {
				numList.set(i, numList.get(i)+num);
				return;//�޼��� ����
			}//��ٱ��Ͽ� ��� ��ǰ�� ��ȣ�� ��ġ�ϴ� ���, ��ǰ������ ����
		}//codeList�� �ִ� ��ǰ�� ������ŭ �ݺ�
		codeList.add(code); //codeList�� �� ��ǰ ��ȣ ����
		numList.add(num);//numList�� �� ��ǰ�� ���� ����
	}//��ٱ��Ͽ� ��ǰ�� ������ ��� �޼��� 
}
