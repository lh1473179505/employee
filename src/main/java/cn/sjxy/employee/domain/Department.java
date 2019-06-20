package cn.sjxy.employee.domain;

import java.io.Serializable;

public class Department implements Serializable{

	private int did;
	private String dname;
	private String note;
	public int getDid() {
		return did;
	}
	public void setDid(int did) {
		this.did = did;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	@Override
	public String toString() {
		return "Department [did=" + did + ", dname=" + dname + ", note=" + note + "]";
	}
	
}
