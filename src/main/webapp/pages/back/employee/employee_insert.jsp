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
       <h2 class="h2" style="text-align: center">增加员工</h2>
   </div>
            <form action="${pageContext.request.contextPath}/addEmployee" method="get" class="form-horizontal" id="insertForm">
                <%--员工编号--%>
                <div class="form-group">
                    <label for="eid" class="control-label col-md-3">员工编号</label>
                    <div class="col-md-5">
                        <input type="text" class="form-control" name="eid" id="eid" placeholder="请输入员工编号">
                    </div>
                </div>
<%--部门编号--%>
                    <div class="form-group">
                        <label class="control-label col-md-3">部门名称</label>
                        <div class="col-md-5">
                            
                            <select class="form-control"id="did" name="did" >
                                        <c:forEach items="${depts}" var="dept">
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

                    <%--员工年龄--%>
                    <div class="form-group">
                        <label  class="control-label col-md-3">员工性别</label>
                        <div class="col-md-5">
                            <label class="radio-inline">
                                 <input type="radio" name="sex" id="sex" value="1" checked >男
                            </label>
                            <label class="radio-inline">
                                 <input type="radio" name="sex" id="sex"  value="2">女
                            </label>
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
                    <div class="col-md-4 col-md-offset-6">
                        <button type="submit" class="btn btn-success btn-sm">增加</button>
                        <button type="reset" class="btn btn-danger btn-sm">重置</button>
                    </div>
                </div>
            </form>
    </div>


<jsp:include page="/pages/footer.jsp"/>
<script src="jquery/jquery.validate.min.js"></script>
<script src="jquery/additional-methods.min.js"></script>
<script src="jquery/jquery.metadata.js"></script>
<script src="jquery/Message_zh_CN.js"></script>

</body>
</html>
