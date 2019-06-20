package cn.sjxy.employee.test;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.sjxy.employee.Service.AdminService;
import cn.sjxy.employee.Service.EmployeeService;
import cn.sjxy.employee.dao.EmployeeMapper;
import cn.sjxy.employee.domain.Admin;
import cn.sjxy.employee.domain.Department;
import cn.sjxy.employee.domain.Employee;



public class TestUp {

	@Test
	public void testFindAllItem() {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		Employee employee=new Employee();
		Department department=new Department();;
		
		EmployeeService employeeService=context.getBean("employeeService",EmployeeService.class);
		
		employee.setName("heh2e");
		employee.setEid("1");
		
		employee.setName("dog");
		
		employeeService.updateEmp(employee);
		
		
	}
}
