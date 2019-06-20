package cn.sjxy.employee.handler;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.sjxy.employee.Service.DepartmentService;
import cn.sjxy.employee.Service.EmployeeService;
import cn.sjxy.employee.domain.Employee;

@Controller
public class EmployeeHandler {

	@Autowired
	private DepartmentService  departmentService;
	
	public DepartmentService getDepartmentService() {
		return departmentService;
	}

	public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}

	@Autowired
	private EmployeeService employeeService;

	public EmployeeService getEmployeeService() {
		return employeeService;
	}

	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	@RequestMapping(value="/addEmployee",method=RequestMethod.GET)
	public String addEmp(Employee employee,HttpServletRequest request) {
		String msg="";
		String eid=employee.getEid();
		String name=employee.getName();
		int did=employee.getDid(); 
		int age=employee.getAge();
		int sex=employee.getSex();
		String address=employee.getAddress();
		
		if(eid==null || eid=="" || name==null || name=="" || age==0 || address==null || address=="") {
			msg="不能留空！";
			request.setAttribute("msg",msg);
			 request.setAttribute("url","pages/back/employee/employee_insert.jsp");
			return "forward";
		}else if(employeeService.findId(eid)==null) {
			employeeService.insertEmployee(employee);
			msg="插入成功";
			request.setAttribute("msg",msg);
			 request.setAttribute("url","pages/back/employee/employee_insert.jsp");
			return "forward";
		}else {
			msg="添加失败，员工编号重复！";
			request.setAttribute("msg",msg);
			 request.setAttribute("url","pages/back/employee/employee_insert.jsp");
			return "forward";
		}
		
		
	}
	
	@RequestMapping(value="/ShowEmployee",method=RequestMethod.GET)
	public String ShowEmployee(Map<String, Object>map,HttpSession session,HttpServletRequest request) {
		map.put("emps",employeeService.findEmployee() );
		map.put("dept", departmentService.findDept());
		String eid=request.getParameter("eid");
		session.setAttribute("eid", eid);
		return "pages/back/employee/employee_list";
	}
	
	@RequestMapping(value="/deleteEmp",method=RequestMethod.GET)
	public String updateLen(@RequestParam(value="eid",required=false,defaultValue="1")String eid,HttpServletRequest request) {
		String msg="";
		eid=request.getParameter("eid");
		employeeService.deleteEmp(eid);
		msg="删除成功！";
		request.setAttribute("msg",msg);
        request.setAttribute("url","pages/back/employee/includeList.jsp");
        return "forward";
		
		
	}
	
	@RequestMapping(value="/updateEmpById",method=RequestMethod.GET)
	public String updateEmpById(Employee employee,HttpServletRequest request) {
		String msg="";
		String name=employee.getName();
		int age=employee.getAge();
		String address=employee.getAddress();
		if(name==null || name=="" || age==0 || address==null || address=="") {
			msg="添加失败，所有数据不能为空！";
			request.setAttribute("msg",msg);
			 request.setAttribute("url","pages/back/employee/includeList.jsp");
			return "forward";
		}else {
			employeeService.updateEmp(employee);
			msg="修改成功！";
			request.setAttribute("msg",msg);
			 request.setAttribute("url","pages/back/employee/includeList.jsp");
			return "forward";
		}

		
		
	}
	
	
	
}
