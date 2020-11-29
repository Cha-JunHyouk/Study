package senior;

public class Matjip {//DTO:DB와 연동에 사용되는 객체
	private int number;//맛집번호
	private String name;//맛집이름
	private String addr;//맛집주소
	private String tel;//전화번호
	private String mobile;//핸폰번호
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
}
