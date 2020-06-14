package com.com.example.goods.entity;


public class User {
	private Integer id;
	private String name;
	private Integer age;
	private String gender;
	private String phone;
	private String remark;
	private String head;
	private Integer departmentid;
	private Integer roleid;

	public User() {
	}

	public User(Integer id,String name, Integer departmentid) {
		this.id=id;
		this.name = name;
		this.departmentid = departmentid;
	}

	public User(Integer id, String name, Integer age, String gender, String phone, String remark, String head, Integer departmentid, Integer roleid) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.phone = phone;
		this.remark = remark;
		this.head = head;
		this.departmentid = departmentid;
		this.roleid = roleid;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getHead() {
		return head;
	}

	public void setHead(String head) {
		this.head = head;
	}

	public Integer getDepartmentid() {
		return departmentid;
	}

	public void setDepartmentid(Integer departmentid) {
		this.departmentid = departmentid;
	}

	public Integer getRoleid() {
		return roleid;
	}

	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}

	@Override
	public String toString() {
		return "User{" +
				"id=" + id +
				", name='" + name + '\'' +
				", age=" + age +
				", gender='" + gender + '\'' +
				", phone='" + phone + '\'' +
				", remark='" + remark + '\'' +
				", head='" + head + '\'' +
				", departmentid=" + departmentid +
				", roleid=" + roleid +
				'}';
	}
}