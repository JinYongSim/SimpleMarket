package com.scit.SimpleMarket.VO;

public class Member {
	private String adminId; // 관리자 아이디
	private String adminPw; // 관리자 패스워드
	
	private String customerId;
	private String customerPw;
	private String name;
	private String phone;
	private String birthdate;
	private String address;
	private String indate;

	public Member() {
		
	}

	public Member(String adminId, String adminPw) {
		this.adminId = adminId;
		this.adminPw = adminPw;
	}

	public String getAdminId() {
		return adminId;
	}

	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}

	public String getAdminPw() {
		return adminPw;
	}

	public void setAdminPw(String adminPw) {
		this.adminPw = adminPw;
	}

	@Override
	public String toString() {
		return "Member [adminId=" + adminId + ", adminPw=" + adminPw + "]";
	}

	public Member(String customerId, String customerPw, String name, String phone, String birthdate, String address,
			String indate) {
		super();
		this.customerId = customerId;
		this.customerPw = customerPw;
		this.name = name;
		this.phone = phone;
		this.birthdate = birthdate;
		this.address = address;
		this.indate = indate;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getCustomerPw() {
		return customerPw;
	}

	public void setCustomerPw(String customerPw) {
		this.customerPw = customerPw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getIndate() {
		return indate;
	}

	public void setIndate(String indate) {
		this.indate = indate;
	}
	
	
	
	
}
