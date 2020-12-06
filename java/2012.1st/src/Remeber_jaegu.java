package senior;
//DB연동시 데이터를 주고받을 때 사용하는 객체를 DTO
//Data Transfer Object
//DTO를 만들때 주의사항:모든 항목을 비공개(private)로 만든다.
public class Remeber_jaegu {//DTO
	private String id;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	public String getJoindate() {
		return joindate;
	}
	public void setJoindate(String joindate) {
		this.joindate = joindate;
	}
	public String getStar() {
		return star;
	}
	public void setStar(String star) {
		this.star = star;
	}
	//id에 값을 넣는 메서드(세터(setter) 메서드)
	//id에 있는 값을 보여주는 메서드(게터(getter) 메서드)
	private String password;
	private String gender;
	private String address;
	private String name;
	private String phonenumber;
	private String joindate;
	private String star;
}







