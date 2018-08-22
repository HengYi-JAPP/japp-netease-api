<%--
  Created by IntelliJ IDEA.
  User: jzb
  Date: 17-11-9
  Time: 下午4:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <%@include file="commonHead.jsp" %>
</head>
<body class="flex">
<nav class="navbar navbar-default my-nav" role="navigation">
    <div class="container-fluid">
        <div class="collapse navbar-collapse">
            <ul class="nav navbar-nav">
                <li><a href="whiteSet.jsp">白名单</a></li>
                <li><a href="blackSet.jsp">黑名单</a></li>
                <li><a href="companies.jsp">公司</a></li>
                <li><a href="departments.jsp">部门</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li class="active"><a href="members.jsp">最终人员名单</a></li>
            </ul>
        </div>
    </div>
</nav>

<div id="page-content" class="data-container table-responsive">
</div>

<%@include file="commonFoot.jsp" %>
<script src="./js/members.min.js"></script>
<script>
    const page = new Members();
</script>
</body>
</html>
