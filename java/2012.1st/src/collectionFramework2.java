package senior;

import java.util.ArrayList;
import java.util.Iterator;

//�������� ���� DTO
class UserInfo {
	private String code;//���ڵ�
	private String name;//���̸�
	private String address;//���ּ�
	private String tel;//������ó
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
}
public class Lesson2 {
	public static void main(String[] args) {
		ArrayList<UserInfo> al = new ArrayList<UserInfo>();//�������� ����
		//�������� ����
		UserInfo user1 = new UserInfo();
		user1.setCode("001"); user1.setName("ȫ�浿");
		user1.setAddress("����"); user1.setTel("010-2345-9876");
		al.add(user1);//���� List�� ����
		UserInfo user2 = new UserInfo();
		user2.setCode("002"); user2.setName("��浿");
		user2.setAddress("���"); user2.setTel("010-7873-8766");
		al.add(user2);
		UserInfo user3 = new UserInfo();
		user3.setCode("003"); user3.setName("�ֱ浿");
		user3.setAddress("����"); user3.setTel("010-7877-9243");
		al.add(user3);
		//List�� ����� �������� ���(Ž��)
		//List�� Set�� ����� �����͸� ã�´�. ���? Iterator�� ���
		Iterator it = al.iterator();
		while(it.hasNext()) {
			UserInfo info = (UserInfo)it.next();
			System.out.println("���ڵ�:"+info.getCode());
			System.out.println("���̸�:"+info.getName());
			System.out.println("���ּ�:"+info.getAddress());
			System.out.println("������ó:"+info.getTel());
		}
	}
}



















