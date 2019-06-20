package cn.sjxy.employee.dao;

import java.util.List;

import cn.sjxy.employee.domain.Employee;

public interface EmployeeMapper {

	public void saveEmployee(Employee employee);
	
	public List<Employee> findAllEmployee();
	
	public void deleteEmployeeByid(String eid);
	
	public void updateEmpByEid(Employee employee);
	
	public Employee findById(String eid);
}
