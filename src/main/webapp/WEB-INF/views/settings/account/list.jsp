<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title></title>
    <link rel="stylesheet" href="http://cdn.staticfile.org/twitter-bootstrap/2.3.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="http://cdn.staticfile.org/font-awesome/4.1.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="/static/medical/css/style.css">
</head>
<body>
<jsp:include page="../../include/nav.jsp">
    <jsp:param name="menu" value="settings"/>
</jsp:include>

<div class="container-fluid">
    <div class="row-fluid">
        <div class="span12">

            <div class="box">
                <div class="box-header">
                    <span class="title"><i class="fa fa-user-md"></i> 系统账号列表</span>
                    <ul class="unstyled inline pull-right">
                        <li><a href="/account/new"><i class="fa fa-plus"></i> 新建</a></li>
                    </ul>
                </div>
                <div class="box-body">
                    <table class="table">
                        <thead>
                        <tr>
                            <th width="200">账户名称</th>
                            <th width="200">员工姓名</th>
                            <th>电话</th>
                            <th>最后登录时间</th>
                            <th>最后登录IP</th>
                            <th>#</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${userList}" var="user">
                            <tr>
                                <td>${user.username}</td>
                                <td>${user.realname}</td>
                                <td>${user.tel}</td>
                                <td>**</td>
                                <td>**</td>
                                <td>
                                    <a href="">修改</a>
                                    <a href="">禁用</a>
                                    <a href="/account/${user.id}/del">删除</a>
                                </td>
                            </tr>
                        </c:forEach>

                        </tbody>
                    </table>
                </div>
            </div>


        </div>

    </div>
</div>



<script src="http://cdn.staticfile.org/jquery/1.11.1/jquery.min.js"></script>
<script src="http://cdn.staticfile.org/twitter-bootstrap/3.0.0/js/bootstrap.min.js"></script>

</body>
</html>
