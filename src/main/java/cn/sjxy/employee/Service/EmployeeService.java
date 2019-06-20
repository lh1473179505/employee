package cn.sjxy.employee.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.sjxy.employee.dao.EmployeeMapper;
import cn.sjxy.employee.domain.Employee;

@Service
@Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRED)
public class EmployeeService {
	@Autowired
	private EmployeeMapper employeeMapper;

	public EmployeeMapper getEmployeeMapper() {
		return employeeMapper;
	}

	public void setEmployeeMapper(EmployeeMapper employeeMapper) {
		this.employeeMapper = employeeMapper;
	}
	
	public void insertEmployee(Employee employee) {
		employeeMapper.saveEmployee(employee);
	}
	
	public List<Employee> findEmployee(){
		return employeeMapper.findAllEmployee();
	}
	
	public void deleteEmp(String eid) {
		employeeMapper.deleteEmployeeByid(eid);
	}
	
	public void updateEmp(Employee employee) {
		employeeMapper.updateEmpByEid(employee);
	}
	
	public Employee findId(String eid) {
		return employeeMapper.findById(eid);
	}
	
}
