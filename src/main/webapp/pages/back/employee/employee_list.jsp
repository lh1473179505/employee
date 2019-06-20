<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path +"/";
%>
<html>
<head>
    <base href="<%=basePath%>">
    <title>优乐在线教育图书管理系统</title>
</head>
<body>
<jsp:include page="/pages/header.jsp"/>
<!--主体内容编写-->
<div id="page-wrapper">
    <div class="col-md-12">
        <table class="table table-bordered table-hover" id="studentTable">
            <tr>
               
                <th class="text-center">员工编号</th>
                <th class="text-center">员工名字</th>
                <th class="text-center">员工年龄</th>
                <th class="text-center">员工性别</th>
                <th class="text-center">联系地址</th>
                <th class="text-center">操作</th>
            </tr>
            <c:forEach items="${emps}" var="emp">
                   <tr>
                   
                       <td class="text-center">${emp.eid}</td>
                       <td class="text-center">${emp.name}</td>
                        <td class="text-center">${emp.age}</td>
                       <td class="text-center">
                       <c:if test="${emp.sex ==1}">男</c:if>
                       <c:if test="${emp.sex ==2}">女</c:if>
                       
                       </td>
                      
                       <td class="text-center">${emp.address}</td>
                       <td class="text-center">
                      
                       <button type="button" class="btn btn-success">
  			<span class="glyphicon glyphicon-pencil " aria-hidden="true" data-toggle="modal" data-target="#empInfo"></span> 修改
		</button>
		<a href="${pageContext.request.contextPath }/deleteEmp?eid=${emp.eid}">
		<button type="button" class="btn btn-succes">
  			<span class="glyphicon glyphicon-trash" aria-hidden="true"></span> 删除
		</button></a>
                       </td>
                       
                </c:forEach>
        </table>
       
        <div class="text-right">
            <ul class="pagination pagination-sm" id="pagecontrol"></ul>
        </div>
        <div class="alert alert-success" id="alertDiv" style="display: none">
            <button class="close" data-dismiss="alert">&times;</button>
            <span id="alertText"></span>
        </div>
    </div>

    <div class="modal" id="empInfo">
        <div class="modal-dialog">
          <div class="modal-content">
              <div class="modal-header">
                  <button class="close" data-dismiss="modal">&times;</button>
                  <h3 class="modal-title">修改员工信息</h3>
              </div>
              <div class="modal-body">
                  <form method="get" action="${pageContext.request.contextPath }/updateEmpById" class="form-horizontal">
                      <%--员工编号--%>
                      <div class="form-group">
                          <label class="control-label col-md-3">员工编号</label>
                          <div class="col-md-5">
                              <select class="form-control"id="eid" name="eid" >
                                        <c:forEach items="${emps}" var="emp">
                                            <option value="${emp.eid}">${emp.eid}</option>
                                        </c:forEach>
                                    </select>
                          </div>
                      </div>
                      <%--部门编号--%>
                      <div class="form-group">
                          <label class="control-label col-md-3">部门编号</label>
                          <div class="col-md-5">
                              <select class="form-control"id="did" name="did" >
                                        <c:forEach items="${dept}" var="dept">
                                            <option value="${dept.did}">${dept.dname}</option>
                                        </c:forEach>
                                    </select>
                          </div>
                      </div>

                      <%--员工姓名--%>
                      <div class="form-group">
                          <label for="name" class="control-label col-md-3">员工姓名</label>
                          <div class="col-md-5">
                              <input type="text" class="form-control" name="name" id="name" placeholder="请输入员工姓名">
                          </div>
                      </div>


                      <%--员工年龄--%>
                      <div class="form-group">
                          <label for="age" class="control-label col-md-3">员工年龄</label>
                          <div class="col-md-5">
                              <input type="text" class="form-control" name="age" id="age" placeholder="请输入员工年龄">
                          </div>
                      </div>

                      <%--联系地址--%>
                      <div class="form-group">
                          <label for="address" class="control-label col-md-3">联系地址</label>
                          <div class="col-md-5">
                              <input type="text" class="form-control" name="address" id="address" placeholder="请输入员工联系地址">
                          </div>
                      </div>
							
					  <div class="form-group">
                          <label for="sex" class="control-label col-md-3">性别</label>
                          <div class="col-md-5">
                            <label class="radio-inline">
                                 <input type="radio" name="sex" id="sex" value="1" checked >男
                            </label>
                            <label class="radio-inline">
                                 <input type="radio" name="sex" id="sex"  value="2">女
                            </label>
                        </div>
                      </div>

                      <div class="form-group">
                          <div class="col-md-4 col-md-offset-6">
                              
                              <button type="submit" class="btn btn-success btn-sm">修改</button>
                          </div>
                      </div>
                  </form>
              </div>
              <div class="modal-footer">
                  <button class="btn btn-success btn-sm" data-dismiss="modal">关闭编辑窗口</button>
              </div>
          </div>
        </div>
    </div>
</div>

<jsp:include page="/pages/footer.jsp"/>
<script src="jquery/jquery.validate.min.js"></script>
<script src="jquery/additional-methods.min.js"></script>
<script src="jquery/jquery.metadata.js"></script>



</body>
</html>
