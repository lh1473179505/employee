package cn.sjxy.employee.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.sjxy.employee.dao.DepartmentMapper;
import cn.sjxy.employee.domain.Department;

@Service
@Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRED)
public class DepartmentService {

	@Autowired
	private DepartmentMapper  departmentMapper;

	public DepartmentMapper getDepartmentMapper() {
		return departmentMapper;
	}

	public void setDepartmentMapper(DepartmentMapper departmentMapper) {
		this.departmentMapper = departmentMapper;
	}
	
	public void saveDept(Department department) {
		departmentMapper.save(department);
	}
	
	public List<Department> findDept(){
	return 	departmentMapper.findAllDepartment();
	}
}
