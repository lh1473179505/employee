package cn.sjxy.employee.dao;

import cn.sjxy.employee.domain.Admin;

public interface AdminMapper {

	public Admin login(Admin admin);
	
	public Admin findByEmail(String email) ;
	
	public void updateTime(Admin admin);
}
