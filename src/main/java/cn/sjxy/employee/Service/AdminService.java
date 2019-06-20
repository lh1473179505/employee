package cn.sjxy.employee.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.sjxy.employee.dao.AdminMapper;
import cn.sjxy.employee.domain.Admin;

@Service
@Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRED)
public class AdminService {

	@Autowired
	private AdminMapper adminMapper;

	public AdminMapper getAdminMapper() {
		return adminMapper;
	}

	public void setAdminMapper(AdminMapper adminMapper) {
		this.adminMapper = adminMapper;
	}
	
	public Admin getLogin(Admin admin) {
		return adminMapper.login(admin);
	}
	
	public Admin findAdmin(String email) {
		return adminMapper.findByEmail(email);
	}
	
	public void updateAdmin(Admin admin) {
		adminMapper.updateTime(admin);
	}
}
