package cn.sjxy.employee.domain;

import java.io.Serializable;
import java.util.List;

public class Employee implements Serializable{

	private String eid;
	private int did;
	private String name;
	private int age;
	private int sex;
	private String address;
	private Department department;
	public String getEid() {
		return eid;
	}
	public void setEid(String eid) {
		this.eid = eid;
	}
	public int getDid() {
		return did;
	}
	public void setDid(int did) {
		this.did = did;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", did=" + did + ", name=" + name + ", age=" + age + ", sex=" + sex
				+ ", address=" + address + ", department=" + department + "]";
	}
	
	
	
}
