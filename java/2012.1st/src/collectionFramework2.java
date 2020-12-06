package senior;

import java.util.ArrayList;
import java.util.Iterator;

//고객정보를 위한 DTO
class UserInfo {
	private String code;//고객코드
	private String name;//고객이름
	private String address;//고객주소
	private String tel;//고객연락처
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
		ArrayList<UserInfo> al = new ArrayList<UserInfo>();//고객정보만 저장
		//고객정보를 저장
		UserInfo user1 = new UserInfo();
		user1.setCode("001"); user1.setName("홍길동");
		user1.setAddress("서울"); user1.setTel("010-2345-9876");
		al.add(user1);//고객을 List에 저장
		UserInfo user2 = new UserInfo();
		user2.setCode("002"); user2.setName("김길동");
		user2.setAddress("경기"); user2.setTel("010-7873-8766");
		al.add(user2);
		UserInfo user3 = new UserInfo();
		user3.setCode("003"); user3.setName("최길동");
		user3.setAddress("서울"); user3.setTel("010-7877-9243");
		al.add(user3);
		//List에 저장된 고객정보를 출력(탐색)
		//List나 Set에 저장된 데이터를 찾는다. 어떻게? Iterator를 사용
		Iterator it = al.iterator();
		while(it.hasNext()) {
			UserInfo info = (UserInfo)it.next();
			System.out.println("고객코드:"+info.getCode());
			System.out.println("고객이름:"+info.getName());
			System.out.println("고객주소:"+info.getAddress());
			System.out.println("고객연락처:"+info.getTel());
		}
	}
}



















