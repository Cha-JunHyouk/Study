package senior;
//DB������ �����͸� �ְ���� �� ����ϴ� ��ü�� DTO
//Data Transfer Object
//DTO�� ���鶧 ���ǻ���:��� �׸��� �����(private)�� �����.
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
	//id�� ���� �ִ� �޼���(����(setter) �޼���)
	//id�� �ִ� ���� �����ִ� �޼���(����(getter) �޼���)
	private String password;
	private String gender;
	private String address;
	private String name;
	private String phonenumber;
	private String joindate;
	private String star;
}







