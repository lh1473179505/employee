<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path +"/";
%>
<html>
<head>
    <base href="<%=basePath%>">
    <title>三江在线教育员工管理系统</title>
</head>
<body>
<jsp:include page="/pages/header.jsp"/>
<!--主体内容编写-->
<div id="page-wrapper">
   <div class="col-md-12">
       <h2 class="h2" style="text-align: center">增加部门</h2>
   </div>
            <form action="${pageContext.request.contextPath }/insertDepartment" method="post" class="form-horizontal">
                <div class="form-group">
                    <label for="cname" class="control-label col-md-3">部门名称</label>
                    <div class="col-md-5">
                        <input type="text" class="form-control" name="dname" id="dname" placeholder="请输入部门名称">
                    </div>
                </div>
                <div class="form-group">
                    <label for="cname" class="control-label col-md-3">部门简介</label>
                    <div class="col-md-5">
                       <textarea class="form-control" name="note" id="note" placeholder="请输入部门简介"></textarea>
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
