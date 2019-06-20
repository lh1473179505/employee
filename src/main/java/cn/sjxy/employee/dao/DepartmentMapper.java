package cn.sjxy.employee.dao;

import java.util.List;

import cn.sjxy.employee.domain.Department;

public interface DepartmentMapper {

	public void save(Department department);
	
	public List<Department> findAllDepartment();
	
	
}
