package cn.sjxy.employee.handler;



import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.sjxy.employee.Service.AdminService;
import cn.sjxy.employee.domain.Admin;

@Controller
public class AdminHandler {
	
	@Autowired
	AdminService adminService;
	
	
	
	public AdminService getAdminService() {
		return adminService;
	}



	public void setAdminService(AdminService adminService) {
		this.adminService = adminService;
	}



	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String login(Admin admin,HttpServletRequest request,HttpSession session)throws Exception {
		String msg="";
		
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		admin.setEmail(email);
		admin.setPassword(password);
		
		if(email==null || email=="" || password==null || password=="") {
			msg="账号或密码不能为空！";
			request.setAttribute("msg",msg);
			 request.setAttribute("url","login.jsp");
			return "forward";
		}
		
		if(adminService.getLogin(admin)==null) {
		msg="账号或密码错误！";
		request.setAttribute("msg",msg);
		 request.setAttribute("url","login.jsp");
		return "forward";
		}else {
			admin=adminService.findAdmin(email);
			session.setAttribute("admin", admin);
			session.setAttribute("email", admin.getEmail());
			session.setAttribute("lastdate", admin.getLastdate());
			 adminService.updateAdmin(admin);
			 Date lastdate=admin.getLastdate();
			
			 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			 
			if(lastdate!=null)session.setAttribute("lastdate", sdf.format(lastdate));
			 else {session.setAttribute("lastdate", "首次登录");}
			
			
			msg="来了老弟！";
			request.setAttribute("msg",msg);
			 request.setAttribute("url","login.jsp");
			 request.setAttribute("msg",msg);
		        request.setAttribute("url","pages/back/index.jsp");
		        return "forward";
			
		}
		
	}
	
	@RequestMapping(value="/logout",method=RequestMethod.GET)
	public String logout(HttpSession session,HttpServletRequest request) {
		String msg="";
		session.invalidate();
		msg="退出成功！再来打死你！";
        request.setAttribute("msg",msg);
	        request.setAttribute("url","login.jsp");
	        return "forward";
	}
	
	@RequestMapping(value="/welcome",method=RequestMethod.GET)
	public String index(HttpServletRequest request) {
		if(request.getSession().getAttribute("admin") != null) {
			return "pages/back/index";
		}else {
			String msg="你还未登录！";
			request.setAttribute("msg",msg);
	        request.setAttribute("url","login.jsp");
	        return "forward";
			
		}
		
		
	}
}
