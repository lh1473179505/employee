package cn.sjxy.employee.handler;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.sjxy.employee.Service.DepartmentService;
import cn.sjxy.employee.domain.Department;

@Controller
public class DepartmentHandler {

	@Autowired
	private DepartmentService departmentService;

	public DepartmentService getDepartmentService() {
		return departmentService;
	}

	public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}
	
	@RequestMapping(value="/insertDepartment",method=RequestMethod.POST)
	public String insertDept(Department department,HttpServletRequest request) {
		String msg="";
		String dname=request.getParameter("dname");
		String note=request.getParameter("note");
		if(dname==null || dname=="" || note==null || note=="") {
			msg="不能留空！";
			request.setAttribute("msg",msg);
			 request.setAttribute("url","pages/back/department/department_insert.jsp");
			return "forward";
		}else {
			department.setDname(request.getParameter("dname"));
			department.setNote(request.getParameter("note"));
			departmentService.saveDept(department);
			msg="添加成功！";
			request.setAttribute("msg",msg);
			 request.setAttribute("url","pages/back/department/department_insert.jsp");
			return "forward";
		}
		
		
	}
	
	@RequestMapping(value="/showDepartment",method=RequestMethod.GET)
	public String showDepartment(Map<String, Object>map) {
		
		map.put("dept", departmentService.findDept());
		//List<Department> list=departmentService.findDept();
//		for(Department lists:list) {
//			System.out.println(lists.toString());
//		}
		return "pages/back/department/department_list";
	}
	
	@RequestMapping(value="/ShowSelect",method=RequestMethod.GET)
	public String ShowSelect(HttpSession session) {
		
		session.setAttribute("depts",departmentService.findDept() );
		return "pages/back/employee/employee_insert";
	}
	
	@RequestMapping(value="/addDept",method=RequestMethod.GET)
	public String addDept() {
		
		
		return "pages/back/department/department_insert";
	}
	
	
}
